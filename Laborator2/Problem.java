public class Problem {
    Solution sol;
        Destination dest;
        int cost;

        public Problem(String numeSol, Solution.SourceType tipSol, int cantitateSol, String numeDest, int cerereDest, int costProblema){
            sol= new Solution(numeSol,tipSol,cantitateSol);
            dest=new Destination(numeDest,cerereDest);
            cost=costProblema;
        }

        public Problem(Solution solutie, Destination destinatie, int costProblema){
            sol=solutie;
            dest=destinatie;
            cost=costProblema;
        }

        public String toString(){
            return String.format("Sursa " + sol.name + " de tipul " + sol.type + " care are " + sol.supply + " resurse, poate trimite catre destinatia " +  dest.name + ", care are cererea de " + dest.demand + " cu un cost de " + cost);
        }

}
