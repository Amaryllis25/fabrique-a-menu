package com.cicdlectures.menucli.subCommand;

import java.io.IOException;
import java.lang.String;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

import org.json.*;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(
        name = "list-menus",
        description = {"List all menus from menu-server"}
)
public class ListMenus implements Runnable {

    @CommandLine.Option(names = "--server-url", description = "Server where the menus are")
    private String server = "https://fabrique-menu.herokuapp.com";

    // create a client
    private HttpClient client = HttpClient.newHttpClient();

    // create a request
    private HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(this.server + "/menus"))
        .header("Content-Type", "application/json")
        .GET()
        .build();


    public void run()  {
        
        try {
            // use the client to send the request
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            try {
                JSONArray lstMenus = new JSONArray(response.body());

                // Format output data for each menu
                for (int i = 0; i < lstMenus.length(); i++) {

                    JSONObject menu = lstMenus.getJSONObject(i);
                    System.out.println("(id: " + menu.getInt("id") + ") " + menu.getString("name"));

                    JSONArray dishes = menu.getJSONArray("dishes");

                    // For each dishes in a menu
                    for (int j = 0; j < dishes.length(); j++) {
                        JSONObject dish = dishes.getJSONObject(j);
                        System.out.println(dish.getString("name"));
                    }
                    System.out.println("\n");
                }
            }
            catch(JSONException e){
                e.printStackTrace();
            }   
        }
        catch(IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}