package org.example;
import com.ibm.cloud.cloudant.v1.Cloudant;
import com.ibm.cloud.cloudant.v1.model.*;

import java.util.Arrays;

public class HubInfoCollector {
    private Cloudant service;
    private String dbName;
    private String ddocName;
    private String indexName;
    public HubInfoCollector()
    {
        this.service = Cloudant.newInstance();
        this.dbName = "airportdb";
        this.ddocName = "view1";
        this.indexName = "geo";

    }
    public SearchResult getClosestHubsDetails(double fromLat, double toLat, double fromLon, double toLon, double userLat, double userLon) {
        PostSearchOptions searchOptions = new PostSearchOptions.Builder()
                .db(dbName)
                .ddoc(ddocName)
                .index(indexName)
                .query(String.format("lat:[%s TO %s] AND lon:[%s TO %s]", fromLat, toLat, fromLon, toLon))
                .sort(Arrays.asList(String.format("<distance,lon,lat,%s,%s,km>", userLat, userLon)))
                .build();
        SearchResult result = service.postSearch(searchOptions).execute().getResult();
        return result;
    }
}
