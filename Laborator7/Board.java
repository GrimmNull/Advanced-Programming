package Laborator7;

public class Board {
    private Integer n=9;
    private Token[][] game= new Token[n][n];
    Board(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                game[i][j]=new Token(i,j);
            }
        }
    }
    Board(Integer[][] values){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                game[i][j]=new Token(i,j,values[i][j]);
            }
        }
    }
    public void printBoard(){
        System.out.print("  ");
        for(int i=0;i<n;i++){
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
        for(int i=0;i<n;i++){
            System.out.print(i);
            System.out.print(" ");
            for(int j=0;j<n;j++){
                if(game[i][j]==null){
                    System.out.print("x ");
                }else{
                    System.out.print(game[i][j].getValue());
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public void takePiece(Integer x, Integer y){
        game[x][y]=null;
    }
}
