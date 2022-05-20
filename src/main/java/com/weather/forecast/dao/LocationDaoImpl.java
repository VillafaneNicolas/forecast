package com.weather.forecast.dao;

import com.weather.forecast.model.Location;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class LocationDaoImpl implements LocationDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void persistLocations(List<Location> locations) {

        for(Location location : locations){
            em.merge(location);
        }

    }

}
