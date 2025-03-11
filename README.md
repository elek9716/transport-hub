This app retrieves data about the closest transport hubs within a specified geographical range. It interacts with IBM's Cloudant database to fetch this information.

Classes

1. HubInfoCollector

This class is responisble for querying the Cloudant database to retrieve information based on geospatial search parameters.
The class has the following fields:
-Cloudant service: an instance of the Cloudant API client
-String dbName: name of the database that is queried
-String ddocName: name of the design document
-String indexName: the name of the index that's used for geospatial queries

Constructor:
```
public HubInfoCollector()
```
The constructor initalizes the Cloudant service and sets the name of the database, the name of the design document and the name of the search index

Methods:
```
public SearchResult getClosestHubsDetails(double fromLat, double toLat, double fromLon, double toLon, double userLat, double userLon)
```
The getClosestHubDetails method queries Cloudant with the latitude and longitude range filters, then returns a sorted collection of hubs (SearchResult).

2. TransportApp


This is the main entry point of the application, handling user input and calling HubInfoCollector. It reads the longitude and latitude inputs from the user then calls HubInfoCollector to fetch and display this data for the user.

Helper methods:
```
private static double getValidLatitude(Scanner scanner, String prompt)
```
Validates user input for latitude (latitude can only be between -90 and 90).
```
private static double getValidLongitude(Scanner scanner, String prompt)
```
Validates user inpot for longitude (longitude can only be between -180 and 180).

Usage
Open a command terminal and navigate to the folder where transport-hub.jar is located. Set the necessary environment variables (AUTH_TYPE = NOAUTH and CLOUDANT_URL=https://mikerhodes.cloudant.com/), then run the JAR.
Follow the prompts and enter your desired latitude and longitude ranges.



