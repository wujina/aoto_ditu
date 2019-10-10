package com.aoto.framework.security.persistence.inf;

import com.aoto.framework.security.models.Citycoordinates;


import java.util.List;

/**
 * 
 * @author ecmybatis
 */
public interface CitycoordinatesDao {
  
  // You can type your methods hereas
    void save(Citycoordinates model);

    List <Citycoordinates>getAll();
  
}