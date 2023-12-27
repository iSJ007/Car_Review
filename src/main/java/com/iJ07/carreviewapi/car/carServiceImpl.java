package com.iJ07.carreviewapi.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class carServiceImpl implements carService {

    @Autowired
    carRepository CarRepository;
    @Override
    public Car fetchCarById(Integer carId) {
        return CarRepository.findById(carId);
    }

    @Override
    public List<Map<String, Object>> fetchCarByName(String keyWord) {
        return CarRepository.findByName(keyWord);
    }
}
