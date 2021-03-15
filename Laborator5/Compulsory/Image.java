package Laborator5;

public class Image extends Item {
    private String extension,resolution;
    Image(String nume, String tip, String cale, String extensie, String rezolutie){
        super(nume,tip,cale);
        extension=extensie;
        resolution=rezolutie;
    }
    public String getType(){
        return "image";
    }
    public String getExtension(){
        return extension;
    }
    public void setExtension(String extensie){
        extension=extensie;
    }
    public String getResolution(){
        return resolution;
    }
    public void setResolution(String rezolutie){
        resolution=rezolutie;
    }
    public String toString(){
        StringBuilder temp=new StringBuilder();
        temp.append(getName());
        temp.append(" ");
        temp.append(getType());
        temp.append(" ");
        temp.append(extension);
        temp.append(" ");
        temp.append(resolution);
        temp.append(" ");        
        temp.append(getPath());
        return temp.toString();
    }
}
