import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Freq implements Command{
    @Override
    public void run() {
        System.out.print("Donne un chemin de fichier : ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        exec_f(name);
    }
    public static void exec_f(String path)
    {
        try {
            String file = java.nio.file.Files.readString(Paths.get(path));
            //file = file.replaceAll("\\.|!|\\?|,|:|;|", " ");
            file = file.toLowerCase();
            String [] array = file.split(" ");
            //String [] array = new String[]{"tutu","","toto","titi","tutu","tutu","toto"};
            Map<String, Long> countByWord = Arrays.stream(array)
                    .filter(e->!e.isBlank())
                    .map(s->s.toLowerCase())
                    .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
            Function<Map.Entry<String,Long>,Long> extractor = e -> e.getValue();
            String three = countByWord.entrySet().stream()
                    .sorted(Comparator.comparing(extractor).reversed())
                    .limit(3)
                    .map(e->e.getKey())
                    .collect(Collectors.joining( " "));
            System.out.println(three);
        }
        catch (Exception e) {
            System.out.println("Unreadable file : "+e.getClass());;
        }
    }

    @Override
    public String name() {
        return "freq";
    }
}
