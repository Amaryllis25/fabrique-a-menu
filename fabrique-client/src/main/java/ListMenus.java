import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Command(
        name = "list-menus",
        description = {"list all menus from menu-server"}
)
public class ListMenus implements Runnable {

    // create a client
    HttpClient client = HttpClient.newHttpClient();

    // create a request
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://fabrique-menu.herokuapp.com/menus"))
        .GET()
        .build();

    public void run()  {
        
        try {
            // use the client to send the request
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // the response:
            System.out.println(response.body());
        }
        catch(IOException e) {
        }
        catch(InterruptedException e) {
        }

        System.out.println("list-menus!");
    }
}