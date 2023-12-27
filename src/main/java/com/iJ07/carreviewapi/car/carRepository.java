package com.iJ07.carreviewapi.car;

import com.iJ07.carreviewapi.auth.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface carRepository {

    Car findById(Integer car_id);
    List<Map<String, Object>> findByName(String keyWord) ;
}
