import java.util.Random;
import java.util.Arrays;

public class Optional {
    public static boolean[][] matriceAdiacenta, matriceArbore;
    public static Integer[] vectorVizite,vectorOrdineVizite;
    public static int n,indexVizita=1,indexComponenta=1, urmatorulNod=0;
    public static boolean outputLog=true;
    public static void DFS(int nodCurent)
    {
            vectorVizite[nodCurent]=indexComponenta;
            vectorOrdineVizite[nodCurent]=indexVizita;
            indexVizita=indexVizita+1;
            for(int i=0;i<n;i++){
                if(matriceAdiacenta[nodCurent][i] && vectorVizite[i]!=1){
                    matriceArbore[nodCurent][i]=true;
                    DFS(i);
                    
                }
            }
    }
    public static void main(String args[]) 
    {
        long startTime = System.nanoTime();
        try{
            n=Integer.parseInt(args[0]);
        }catch(Exception e){
            System.out.println("Argumentul nu este valid!");
            return;
        }
        System.out.println(n);
        if(n>30_000){
            outputLog=false;
        }
        Random rand= new Random();
        boolean existaElementNevizitat,existaComponenteConexe;
        matriceAdiacenta=new boolean[n][n];
        matriceArbore=new boolean[n][n];
        vectorVizite=new Integer[n];
        vectorOrdineVizite=new Integer[n];
        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                matriceAdiacenta[i][j]=(rand.nextInt(2)==1 ? true : false);
                matriceAdiacenta[j][i]=matriceAdiacenta[i][j];
            }
        }
        if(outputLog==true){
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                   System.out.print((matriceAdiacenta[i][j]? 1 : 0)); 
                   System.out.print(" ");
                }
                System.out.println();
            }
        }
        do{
            DFS(urmatorulNod);
            existaElementNevizitat= Arrays.stream(vectorVizite).anyMatch(x -> x == 0);
            if(existaElementNevizitat==true)
            {
                urmatorulNod=Arrays.asList(vectorVizite).indexOf(0);
                indexComponenta=indexComponenta+1;
            }
        }while(existaElementNevizitat!=false);


        existaComponenteConexe= Arrays.stream(vectorVizite).anyMatch(x -> x == 2);
        if(existaComponenteConexe==true){
            if(outputLog==true)
            {
                System.out.println("Graful nu este conex");
                for(int i=1;i<=indexComponenta;i++) {
                    for(int j=0;j<n;j++){
                        if(vectorVizite[j]==i){
                            System.out.print(j);
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                 }
            }


        } else {
            if(outputLog==true)
            {
                System.out.println("Graful este conex");
                for(int i=0;i<n;i++) {
                    for(int j=0;j<n;j++) {
                       System.out.print(matriceArbore[i][j]);
                       System.out.print(" ");
                    }
                    System.out.println();
                }
    
            }
         }

         long endTime = System.nanoTime();
         long duration = (endTime - startTime);
         if(outputLog==false)
         System.out.println("Timpul este de: " + duration + " nanosecunde");
    }

}
