package com.aoto.framework.security.service.inf;

import com.aoto.framework.security.models.Citycoordinates;

import java.util.List;

public interface CitycoordinatesService {
    String save(List<Citycoordinates> model);

    List <Citycoordinates>getAll();
}
