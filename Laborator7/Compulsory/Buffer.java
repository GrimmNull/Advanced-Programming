package Laborator7;

public class Buffer {
    private Integer index;
    private Integer maxIndex;
    Buffer(Integer max){
        index=0;
        maxIndex=max;
    }
    public void incIndex(){
        if(index==maxIndex){
            index=0;
        }else{
            index++;
        }

    }
    public Integer getIndex(){
        return index;
    }
}
