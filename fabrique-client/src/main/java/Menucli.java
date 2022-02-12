import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.ParameterException;
import picocli.CommandLine.Spec;


@Command(
    name = "menucli",
    description = {"link with menu-server API"},
    subcommands = { DeleteMenu.class, CommandLine.HelpCommand.class }
)
public class Menucli implements Runnable {

    @Spec
    CommandSpec spec;

    @Override
    public void run() {
        System.out.println("Hello World!");
        throw new ParameterException(spec.commandLine(), "Specify a subcommand");
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Menucli()).execute(args);
        System.exit(exitCode);
    }
}

