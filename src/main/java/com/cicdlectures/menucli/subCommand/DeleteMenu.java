package com.cicdlectures.menucli.subCommand;

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
        name = "delete-menu",
        description = {"Delete a menu"}
)
public class DeleteMenu implements Runnable {

    @Option(names = "--server-url", description = "Server where the menus are")
    private String server = "https://fabrique-menu.herokuapp.com/menus";

    @CommandLine.Parameters(defaultValue = "0", description = "test")
    public String id;

    public void run() {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest
                .newBuilder(URI.create(this.server + "/menus/" + id))
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
