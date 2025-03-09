package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.*;



import java.util.*;

public class TransportApp {

    public static void main(String[] args) {

        var client = Cloudant.newInstance();
       /* System.out.println(client.getAllDbs());
        System.out.println(client.getServiceUrl());
        var serverInfo = client.getServerInformation().execute().getResult();
        System.out.println(serverInfo);
        System.out.println("---------");
        String dbName = "airportdb";*/




        PostSearchOptions searchOptions = new PostSearchOptions.Builder().db("airportdb").ddoc("view1").index("geo")
                .query("lat:[47.3 TO 47.8] AND lon:[19.0 TO 19.5]").sort(Arrays.asList("<distance,lon,lat,-47.3,40.7,km>")).build();
       ;
        SearchResult responsee = client.postSearch(searchOptions).execute().getResult();

        System.out.println(responsee);







    }
}
