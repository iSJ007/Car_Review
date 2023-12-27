package com.iJ07.carreviewapi.car;


import com.iJ07.carreviewapi.auth.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/carapi/cars")
public class carController {

    @Autowired
    carService CarService;

    @GetMapping("/{carId}")
    public ResponseEntity<Object> getCar(HttpServletRequest request,
                                                  @PathVariable("carId") Integer carId ) {

        Car car = CarService.fetchCarById(carId);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @GetMapping("/autocomplete/{keyWord}") // autocomplete
    public ResponseEntity<Object> autoCompleteCar(HttpServletRequest request,
                                                  @PathVariable("keyWord") String keyWord ) {
        List<Map<String, Object>> responseMap = new ArrayList<>();
        responseMap = CarService.fetchCarByName(keyWord);
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }

}
