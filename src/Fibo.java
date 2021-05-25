
import java.util.Scanner;

public class Fibo implements Command{

    @Override
    public void run() {
        System.out.print("un nombre : ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        try {
            System.out.println(fibo(Integer.valueOf(name)));
        } catch (Exception e) {
            System.out.println("Error :" + e.toString());

        }
    }
        public static int fibo(int n)
        {
            if (n < 2) return(n);
            return(fibo(n-2) + fibo(n-1) );
        }

    @Override
    public String name() {
        return "fibo";
    }
}

