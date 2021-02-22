public class Destination {
    String name;
        int demand;

        public Destination(){
            name=new String("default");
            demand=-1;
        }

        public Destination(String nume, int cerere){
            name=new String(nume);
            demand=cerere;
        }

        public String toString(){
            return String.format("Destinatia " + name + " care are cererea de " + demand + " resurse");
        }

        public String getName(){
            return name;
        }

        public int getDemand(){
            return demand;
        }

        public void setName(String nume){
            name=nume;
        }

        public void setDemand(int cerere){
            demand=cerere;
        }

}
