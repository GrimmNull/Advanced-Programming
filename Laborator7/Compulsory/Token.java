package Laborator7;

public class Token {
    private Integer Max=5;
    private Integer posX, posY;
    private Integer value;
    Token(){
        posX=-1;
        posY=-1;
        value=0;
    }
    Token(Integer pozX, Integer pozY, Integer valoare){
        posX=pozX;
        posY=pozY;
        value=valoare;
    }
    Token(Integer pozX, Integer pozY){
        posX=pozX;
        posY=pozY;
        value=(int)(Math.random() * (Max + 1));
    }
    public Integer getX(){
        return posX;
    }
    public Integer getY(){
        return posY;
    }
    public Integer getValue(){
        return value;
    }
    public void setX(Integer pos){
        posX=pos;
    }
    public void setY(Integer pos){
        posY=pos;
    }
    public void setValue(Integer pos){
        value=pos;
    }
}
