package com.weather.forecast.service;

import com.weather.forecast.model.Location;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

public interface LocationService {

    List<Location> retrieveJson() throws IOException, InterruptedException;

}
