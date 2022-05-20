package com.weather.forecast.dao;

import com.weather.forecast.model.Location;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class LocationDaoImpl implements LocationDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(List<Location> locations) {

        //persistimos cada registro de la lista en la base de datos
        for (Location location : locations) {
            entityManager.merge(location);
        }

    }

}
