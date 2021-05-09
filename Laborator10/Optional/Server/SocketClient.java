import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;

class SocketClient extends Thread {
    private Socket socket = null;

    public SocketClient(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            socket.setSoTimeout(30000);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request;
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            String raspuns = "";
            Boolean running = true;
            while (running) {
                try {
                    request = null;
                    request = in.readLine();
                } catch (SocketTimeoutException e) {
                    System.out.println("N-am primit nicio comanda si termin conexiunea cu " + socket.getPort());
                    request = "exit";
                }
                String[] args = request.split(" ");
                switch (args[0]) {
                    case "login": {
                        if (args.length > 2) {
                            raspuns = "There were too many arguments given";
                        } else {
                            args[0] = Integer.toString(socket.getPort());
                            raspuns = new Login().execute(args);
                        }
                        break;
                    }
                    case "register": {
                        if (args.length > 2) {
                            raspuns = "There were too many arguments given";
                        } else {
                            args[0] = Integer.toString(socket.getPort());
                            raspuns = new Register().execute(args);
                        }
                        break;
                    }
                    case "send": {
                        ArrayList<String> arrayOfStrings = new ArrayList<>();
                        arrayOfStrings.add(Integer.toString(socket.getPort()));
                        arrayOfStrings.add(request.replace("send", ""));
                        raspuns = new Send().execute(arrayOfStrings.toArray(new String[0]));
                        break;
                    }
                    case "read": {
                        if (args.length > 1) {
                            raspuns = "There were too many arguments given";
                        } else {
                            args[0] = Integer.toString(socket.getPort());
                            raspuns = new Read().execute(args);
                        }
                        break;
                    }
                    case "friend": {
                        args[0] = Integer.toString(socket.getPort());
                        raspuns = new Friend().execute(args);
                        break;
                    }
                    case "logout": {
                        if (args.length > 1) {
                            raspuns = "There were too many arguments given";
                        } else {
                            args[0] = Integer.toString(socket.getPort());
                            raspuns = new Logout().execute(args);
                        }
                        break;
                    }
                    case "exit": {
                        if (args.length > 2) {
                            raspuns = "There were too many arguments given";
                        } else {
                            args[0] = Integer.toString(socket.getPort());
                            raspuns = new Logout().execute(args);
                            running = false;
                        }
                        break;
                    }
                    case "stop": {
                        if (args.length > 2) {
                            raspuns = "There were too many arguments given";
                        } else {
                            SocketServer.stopServer();
                            raspuns = "The server will shutdown after all clients disconnect";
                            running = false;
                        }
                        break;
                    }
                    default: {
                        raspuns = "I don't know this command";
                    }
                }
                out.println(raspuns);
                out.flush();
                SocketServer.printUsers();
            }

        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}