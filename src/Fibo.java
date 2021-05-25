
import java.util.Scanner;

public class Fibo implements Command{

    @Override
    public void run() {
        System.out.print("un nombre : ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        try {
            System.out.println(exec(Integer.valueOf(name)));
        } catch (Exception e) {
            System.out.println("Error :" + e.toString());

        }
    }
        public static int exec(int n)
        {
            if (n < 2) return(n);
            return(exec(n-2) + exec(n-1) );
        }

    @Override
    public String name() {
        return "fibo";
    }
}

