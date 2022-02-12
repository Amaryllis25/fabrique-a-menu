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

    @CommandLine.Parameters(defaultValue = "0", description = "test")
    public String message1;

    public void run() {
        try {
            System.out.println(message1);

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder(URI.create("https://menuserverapp.herokuapp.com/menus/" + message1))
                    .DELETE()
                    .build();

            // use the client to send the request
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // the response:
            System.out.println(response.statusCode());
            System.out.println(response.body());
        }
        catch (IOException e) {
        }
        catch (InterruptedException e) {
        }
    }
} 
