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
![image](https://github.com/user-attachments/assets/5d04951f-c543-406a-a569-719abcb4b138)
The constructor initalizes the Cloudant service and sets the name of the database, the name of the design document and the name of the search index

Methods:
![image](https://github.com/user-attachments/assets/55bb55ce-46a9-4be6-a3f7-a2062ef43124)
The getClosestHubDetails method queries Cloudant with the latitude and longitude range filters, then returns a sorted collection of hubs (SearchResult).

3. TransportApp
This is the main entry point of the application, handling user input and calling HubInfoCollector. It reads the longitude and latitude inputs from the user then calls HubInfoCollector to fetch and display this data for the user.

Helper methods:



