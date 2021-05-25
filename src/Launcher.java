import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;


public class Launcher {
    public static void main (String[]args) {
        List<Command> commands = List.of(new Quit(), new Fibo(), new Freq());
        Map<String, Command>command_by_name = commands.stream().collect(Collectors.toMap(c->c.name(),c->c));
        System.out.println("Coucou");
        Scanner scanner = new Scanner(System.in);
        //System.out.print("ton nom : ");
        boolean shouldQuit = false ;
        String userInput = "";
        do
        {
            System.out.print("Entrez une commande : ");
            userInput = scanner.nextLine();
            Command current = command_by_name.get(userInput);
            if (current == null)
            {
                System.out.println("Unknown Command");
            }
            else
            {
                current.run();
                if (current.name().equals("quit"))
                {
                    shouldQuit = true;
                }
            }
        }while (shouldQuit == false);
    }
}
