package com.cicdlectures.menucli.subCommand;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Command(
        name = "add-menu",
        description = {"Add a menu rapidly"}
)
public class AddMenu implements Runnable{

    @Option(names = "--server-url", description = "Server where the menus are")
    private String server = "https://fabrique-menu.herokuapp.com";

    public void run() {

        String menu = "{\"name\": \"Menu spécial scout\", \"dishes\": [{\"name\": \"Entrée : Salade composée assaisonné aux herbes de prairies\"},{\"name\": \"Plat : Poisson acheté faute de prise\"}, {\"name\": \"Dessert : Bananes au chocolat, ouf !\"}]}";

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
