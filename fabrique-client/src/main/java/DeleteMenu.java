import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Command(
        name = "delete-menus",
        description = {"delete a menu"}
)
public class DeleteMenu implements Runnable {

    @Option(names = {"-m", "--message"})
    private String message;

    @Override
    public void run() {
        System.out.println("Committing files in the staging area, how wonderful?");
        if (message != null) {
            System.out.println("The commit message is " + message);
        }
    }
} 
