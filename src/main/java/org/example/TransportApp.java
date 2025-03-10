package org.example;

import java.util.Locale;
import java.util.Scanner;

public class TransportApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        double fromLat = getValidLatitude(scanner, "Enter the latitude range!\nFrom: ");
        double toLat = getValidLatitude(scanner, "To: ");

        double fromLon = getValidLongitude(scanner, "Enter the longitude range!\nFrom: ");
        double toLon = getValidLongitude(scanner, "To: ");

        double userLat = getValidLatitude(scanner, "Enter your location's latitude!\nLatitude: ");
        double userLon = getValidLongitude(scanner, "Enter your location's longitude!\nLongitude: ");

        var hubInfoCollector = new HubInfoCollector();
        var response = hubInfoCollector.getClosestHubsDetails(fromLat, toLat, fromLon, toLon, userLat, userLon);

        System.out.println(response);
    }

    private static double getValidLatitude(Scanner scanner, String prompt) {
        double value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                if (value >= -90 && value <= 90) {
                    return value;
                } else {
                    System.out.println("Invalid latitude! Must be between -90 and 90.");
                }
            } else {
                System.out.println("Invalid input! Please enter a numeric value.");
                scanner.next();
            }
        }
    }

    private static double getValidLongitude(Scanner scanner, String prompt) {
        double value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                if (value >= -180 && value <= 180) {
                    return value;
                } else {
                    System.out.println("Invalid longitude! Must be between -180 and 180.");
                }
            } else {
                System.out.println("Invalid input! Please enter a numeric value.");
                scanner.next();
            }
        }
    }
}
