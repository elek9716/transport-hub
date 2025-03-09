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










    }
}
