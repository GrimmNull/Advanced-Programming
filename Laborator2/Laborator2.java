

public class Laborator2{

    public static void main(String[] args){
        //instantam solutiile din problema data in exemplu
            Solution sol1=new Solution("S1",Solution.SourceType.FACTORY,10);
            Solution sol2=new Solution("S2",Solution.SourceType.WAREHOUSE,35);
            Solution sol3=new Solution("S3",Solution.SourceType.WAREHOUSE,25);


        //instantam destinatiile din problema
            Destination dest1=new Destination("D1",20);
            Destination dest2=new Destination("D2",25);
            Destination dest3=new Destination("D3",25);


        //instantam obiectele de tip Problem pe care le vom folosi la afisarea matricii
            Problem[][] prb=new Problem[3][3];
            prb[0][0]=new Problem(sol1,dest1,2);
            prb[0][1]=new Problem(sol1,dest2,3);
            prb[0][2]=new Problem(sol1,dest3,1);
            prb[1][0]=new Problem(sol2,dest1,5);
            prb[1][1]=new Problem(sol2,dest2,4);
            prb[1][2]=new Problem(sol2,dest3,8);
            prb[2][0]=new Problem(sol3,dest1,5);
            prb[2][1]=new Problem(sol3,dest2,6);
            prb[2][2]=new Problem(sol3,dest3,8);

        //formatare pentru aspect si afisam numele destinatiilor    
            System.out.print("   ");
            for(int i=0;i<3;i++){
                System.out.print(prb[0][i].dest.name + " ");
            }

        //afisam costurile problemelor
            System.out.println();
            for(int i=0;i<3;i++){
                System.out.print(prb[i][0].sol.name + " ");
                for(int j=0;j<3;j++){
                    System.out.print(prb[i][j].cost + "  ");
                }
                System.out.print(prb[i][0].sol.supply);
                System.out.println();
            }
            
        //afisam cantitatile necesare
            System.out.print("   ");
            for(int i=0;i<3;i++){
                System.out.print(prb[0][i].dest.demand + " ");
            }

        //afisam cate un obiect din fiecare clasa pentru a demonstra suprascrierea functiei toString
            System.out.println();
            System.out.println(sol1);
            System.out.println(dest1);
            System.out.println(prb[0][0]);
    }
}