public class Hello
{
    public static void main(String args[]) 
    {
        //System.out.println("Hello world!");
        String languages[]={"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        n= n * 3;
        n= n + Integer.parseInt("10101",2);
        n= n + Integer.parseInt("FF",16);
        n= n * 6;
        int sum = 0;
        while (n>0)
        {
            sum= sum + n % 10;
            n= n / 10;
        }
        while(sum>10)
        {
            n = sum;
            sum=0;
            while (n>0)
            {
                sum= sum + n % 10;
                n= n / 10;
            }
        }
        StringBuilder sb= new StringBuilder("Willy-nilly, this semester I will learn ");
        sb.append(languages[sum]);
        System.out.println(sb);

    }
}
