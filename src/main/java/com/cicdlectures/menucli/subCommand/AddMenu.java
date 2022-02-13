package com.cicdlectures.menucli.subCommand;

import picocli.CommandLine;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@CommandLine.Command(
        name = "add-menu",
        description = {"Add a menu rapidly"}
)
public class AddMenu implements Runnable{

    @CommandLine.Option(names = "--server-url", description = "Server where the menus are")
    private String server = "https://fabrique-menu.herokuapp.com";

    @CommandLine.Parameters(defaultValue = "0", description = "test")
    public String message1;

    public void run() {

        String menu = "{\"name\": \"Menu spécial scout\", \"dishes\": [{\"name\": \"Salade composée assaisonné aux herbes de prairies\"},{\"name\": \"Poisson acheté faute de prise\"}, {\"name\": \"Bananes au chocolat, ouf !\"}]}";

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create(this.server + "/menus"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(menu))
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
