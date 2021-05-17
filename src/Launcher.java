import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Launcher {
    public static int fibo(int n)
    {
        if (n < 2) return(n);
        return(fibo(n-2) + fibo(n-1) );
    }
    public static void main (String[]args) {
        System.out.println("coucou");
        Scanner scanner = new Scanner(System.in);
        System.out.print("ton nom :");
        String name = scanner.nextLine();
        System.out.print("commande :");
        name = scanner.nextLine();
        do
        {
         if (name.equals("fibo"))
         {
             System.out.print("un nombre : ");
             name = scanner.nextLine();
             try {
                 System.out.println(fibo(Integer.valueOf(name)));
             }
             catch(Exception e) {
                System.out.println("Error :"+ e.toString());
            }
         }
         /*else if (name.equals("freq"))
         {
             System.out.print("Donne un chemin de fichier : ");
             name =scanner.nextLine();
             try {
                 String file = java.nio.file.Files.readString(Paths.get(name));
                 file.replaceAll("\.|!|\?|");
             } catch (IOException e) {
                 System.out.println("Unreadable file"+ e);
             }
         }
          */
         else {
             System.out.println("Unknown command");

         }
         System.out.print("commande :");
         name = scanner.nextLine();
        } while (!name.equals("quit"));
    }
}
