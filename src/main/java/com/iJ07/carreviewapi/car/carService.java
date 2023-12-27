package com.iJ07.carreviewapi.car;


import java.util.List;
import java.util.Map;

public interface carService {
    Car fetchCarById (Integer carId);
    List<Map<String, Object>> fetchCarByName (String keyWord);
}
