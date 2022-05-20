package com.weather.forecast.service;

import com.weather.forecast.model.Location;

import java.io.IOException;
import java.util.List;

public interface LocationService {

    List<Location> getLocations() throws IOException, InterruptedException;

}
