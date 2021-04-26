import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class SocketClient extends Thread
{
    private Socket socket = null ;
    public SocketClient (Socket socket)
    {
        this.socket = socket ;
    }
    public void run ()
    {
    try {
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String request = in.readLine();
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        String raspuns;
        if(request.equals("stop")){
            SocketServer.stopServer();
            raspuns="The server has stopped";
        }
        else{
            raspuns="The server has accepted the request:" + request;
        }
        out.println(raspuns);
        out.flush();
    } catch (IOException e) {
        System.err.println("Communication error... " + e);
    } finally {try {socket.close();
     } catch (IOException e) { System.err.println (e);
    }
    }
    }
}