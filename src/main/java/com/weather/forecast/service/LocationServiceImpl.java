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
public class LocationServiceImpl implements LocationService {

    private static final String JSON_API_URL = "https://ws.smn.gob.ar/map_items/weather";

    @Autowired
    private LocationDao locationDao;

    @Override
    public List<Location> getLocations() throws IOException, InterruptedException {

        //obtenemos la lista de las ubicaciones desde la peticion de la API
        List<Location> locations = responseToLocation(requestToApi());

        locationDao.save(locations);

        return locations;

    }

    private HttpResponse<String> requestToApi() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        //Instanciamos un request con los datos del API
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(JSON_API_URL))
                .build();
        //El cliente manda la request y recupera el cuerpo del json
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    private List<Location> responseToLocation(HttpResponse<String> response) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        //el mapper separa los elementos del json y devuelve una lista de las ubicaciones
        return mapper.readValue(response.body(), new TypeReference<List<Location>>() {
        });
    }
}
