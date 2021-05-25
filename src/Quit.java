public class Quit implements Command{
    public String name;
    @Override
    public void run() {
            System.exit(1);
    }

    @Override
    public String name() {
        return "quit";
    }
}
