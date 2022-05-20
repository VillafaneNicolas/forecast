package com.weather.forecast.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.forecast.dao.LocationDao;
import com.weather.forecast.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Repository
public class LocationServiceImpl implements LocationService{

    private static final String JSON_API_URL = "https://ws.smn.gob.ar/map_items/weather";

    @Autowired
    private LocationDao locationDao;

    @Override
    public List<Location> retrieveJson() throws IOException, InterruptedException {


            List<Location> locations = parseJsontoLocation(httpRequest());

            locationDao.persistLocations(locations);

        return locations;

    }

    private HttpResponse<String> httpRequest() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept","application/json")
                .uri(URI.create(JSON_API_URL))
                .build();
         return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    private List<Location> parseJsontoLocation(HttpResponse<String> response) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.body(), new TypeReference<List<Location>>() {
        });
    }
}
