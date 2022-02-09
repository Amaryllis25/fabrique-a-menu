import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(
        name = "hello",
        description = {"Says hello"}
)
public class Menucli implements Runnable {

    public static void main(String[] args) {
        CommandLine.run(new Menucli(), args);
    }

    public void run() {
        System.out.println("Hello World!");
    }
}

