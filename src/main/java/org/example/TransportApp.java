package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.*;



import java.util.*;

public class TransportApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Enter the latitude range!");
        System.out.print("From:");
        double fromLat = scanner.nextDouble();
        System.out.print("To:");
        double toLat = scanner.nextDouble();

        System.out.println("Enter the longitude range!");
        System.out.print("From:");
        double fromLon = scanner.nextDouble();
        System.out.print("To:");
        double toLon = scanner.nextDouble();

        System.out.println("Enter your location's latitude!");
        System.out.print("From:");
        double userLat = scanner.nextDouble();
        System.out.print("To:");
        System.out.println("Enter your location's longitude!");
        double userLon = scanner.nextDouble();

        var hubInfoCollector = new HubInfoCollector();
        var response = hubInfoCollector.getClosestHubsDetails(fromLat,toLat,fromLon,toLon,userLat,userLon);

        System.out.println(response);


       // var client = Cloudant.newInstance();
       /* System.out.println(client.getAllDbs());
        System.out.println(client.getServiceUrl());
        var serverInfo = client.getServerInformation().execute().getResult();
        System.out.println(serverInfo);
        System.out.println("---------");
        String dbName = "airportdb";*/




        /*PostSearchOptions searchOptions = new PostSearchOptions.Builder().db("airportdb").ddoc("view1").index("geo")
                .query("lat:[47.3 TO 47.8] AND lon:[19.0 TO 19.5]").sort(Arrays.asList("<distance,lon,lat,-47.3,41.7,km>")).build();
       ;
        SearchResult responsee = client.postSearch(searchOptions).execute().getResult();

        System.out.println(responsee);*/







    }
}
