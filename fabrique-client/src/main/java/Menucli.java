import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(
        name = "menucli",
        description = {"link with menu-server API"}
)
public class Menucli implements Runnable {

    public static void main(String[] args) {
        CommandLine.run(new Menucli(), args);
    }

    public void run() {
        System.out.println("Hello World!");
    }
}

