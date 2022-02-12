import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(
    name = "menucli",
    description = {"link with menu-server API"},
    subcommands = { DeleteMenu.class, CommandLine.HelpCommand.class }
)
public class Menucli implements Runnable {

    public static void main(String[] args) {
        CommandLine.run(new Menucli(), args);
    }

    public void run() {
        System.out.println("Hello World!");
    }
}

