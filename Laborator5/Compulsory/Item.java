package Laborator5;

public abstract class Item {
    private int id;
    private String name,type,path;
    Item(){
        id=-1;
        name="default";
        type="default";
        path="default";
    }
    Item(String nume, String tip, String cale){
        id=-1;
        name=nume;
        type=tip;
        path=cale;
    }

    public int getId(){
        return id;
    }
    public void setId(int nr){
        id=nr;
    }
    public String getName(){
        return name;
    }
    public void setName(String nume){
        name=nume;
    }
    public String getType(){
        return type;
    }
    public void setType(String nume){
        type=nume;
    }
    public String getPath(){
        return path;
    }
    public void setPath(String nume){
        path=nume;
    }
    public String toString(){
        StringBuilder temp=new StringBuilder();
        temp.append(name);
        temp.append(" ");
        temp.append(type);
        temp.append(" ");
        temp.append(path);
        return temp.toString();
    }
}
