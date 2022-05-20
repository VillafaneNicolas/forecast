package com.weather.forecast.controller;

import com.weather.forecast.model.Location;
import com.weather.forecast.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class LocationController {

    @Autowired
    private LocationService locationService;

    @RequestMapping(value = "api/forecast")
    public List<Location> getLocations() throws IOException, InterruptedException {
        //Llamada del servicio que hace el request al API
        return locationService.getLocations();
    }


}
