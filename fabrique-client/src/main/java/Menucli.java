import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.ParameterException;
import picocli.CommandLine.Spec;

@Command(
        name = "menucli",
        subcommands = { ListMenus.class, CommandLine.HelpCommand.class },
        description = {"link with menu-server API"}
)
public class Menucli implements Runnable {

    @Override
    public void run() {
        System.out.println("Use help to know all commands");
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Menucli()).execute(args);
        System.out.println(exitCode);
        System.exit(exitCode);
    }
}

