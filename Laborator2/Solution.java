public class Solution {
    public static enum SourceType {
        WAREHOUSE, FACTORY;
    }
    String name;
    int supply;
    SourceType type;

        public Solution(){
            name=new String("default");
            type=SourceType.FACTORY;
            supply=-1;
        }

        public Solution(String nume, SourceType tipul, int cantitate){
            name=new String(nume);
            type=tipul;
            supply=cantitate;
        }

        public String toString(){
            return String.format("Sursa " + name + " de tipul " + type + " care are " + supply + " resurse");
        }

        public String getName(){
            return name;
        }

        public SourceType getType(){
            return type;
        }

        public int getSupply(){
            return supply;
        }

        public void setName(String nume){
            name=nume;
        }
        public void setType(SourceType tip){
            type=tip;
        }

        public void setSupply(int cantitate){
            supply=cantitate;
        }
}
