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
        name = "delete-menu",
        description = {"Delete a menu"}
)
public class DeleteMenu implements Runnable {

    @Option(names = "--server-url", description = "Server where the menus are")
    private String server = "https://fabrique-menu.herokuapp.com";

    @CommandLine.Parameters(defaultValue = "0", description = "test")
    public String id;

    // create a client
    private HttpClient client = HttpClient.newHttpClient();


    public void run() {
        try {
            // create a request
            HttpRequest request = HttpRequest
                .newBuilder(URI.create(this.server + "/menus/" + id))
                .DELETE()
                .build();

            // use the client to send the request
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // the response
            System.out.println("Menu " + id + " is delete\n");
        }
        catch (IOException e) {
        }
        catch (InterruptedException e) {
        }
    }
} 
