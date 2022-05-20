package com.weather.forecast.dao;


import com.weather.forecast.model.Location;

import java.util.List;

public interface LocationDao {

    void save(List<Location> locations);

}
