package com.cicdlectures.menucli.subCommand;

import java.io.IOException;
import java.lang.String;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(
        name = "add-menu",
        description = {"Add a menu rapidly"}
)
public class AddMenu implements Runnable{

    @Option(names = "--server-url", description = "Server where the menus are")
    private String server = "https://fabrique-menu.herokuapp.com";

    // create a client
    private HttpClient client = HttpClient.newHttpClient();

    // create a fun menu
    private  String menu = "{\"name\": \"Menu spécial scout\", \"dishes\": [{\"name\": \"Entrée : Salade composée assaisonné aux herbes de prairies\"},{\"name\": \"Plat : Poisson acheté faute de prise\"}, {\"name\": \"Dessert : Bananes au chocolat, ouf !\"}]}";


    public void run() {

        try {
            // create a request
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create(this.server + "/menus"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(menu))
                    .build();

            // use the client to send the request
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // the response
            System.out.println("Menu spécial scout added !\n");
        }
        catch (IOException e) {
        }
        catch (InterruptedException e) {
        }
    }
}
