package com.aoto.framework.security.service.impl;

import com.aoto.framework.security.models.Citycoordinates;
import com.aoto.framework.security.persistence.inf.CitycoordinatesDao;
import com.aoto.framework.security.service.inf.CitycoordinatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: framework-web
 * @description:
 * @author: Mr.wuj
 * @create: 2019-09-25 16:27
 **/
@Service
public class CitycoordinatesServiceImpl implements CitycoordinatesService {

    @Autowired
    protected CitycoordinatesDao citycoordinatesDao;

    @Override
    public String save(List<Citycoordinates> model) {

        for (Citycoordinates temp:model) {
            if(temp.getCityID()==null){
                return "城市id不能为null";
            }
            if(temp.getCityName()==null){
                return "城市名称不能为空";
            }
            if (temp.getAdministrativeAreaID()==null){
                return "行政区id不能为null";
            }
            if (temp.getAdministrativeAreaName()==null){
                return "行政区名字不能为空";
            }
            if (temp.getCenter_x()==null){
                return "行政区经度不能为空";
            }
            if(temp.getCenter_y()==null){
                return "行政区维度不能为空";
            }
        }
        model.stream().forEach(s-> citycoordinatesDao.save(s));
        return null;
    }

    @Override
    public List<Citycoordinates> getAll() {
        return citycoordinatesDao.getAll();
    }
}
