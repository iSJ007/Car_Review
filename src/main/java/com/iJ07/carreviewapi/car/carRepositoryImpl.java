package com.iJ07.carreviewapi.car;

import com.iJ07.carreviewapi.auth.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



import java.util.Collections;

import java.util.List;
import java.util.Map;


@Repository
public class carRepositoryImpl implements  carRepository{
    private static final String SQL_FIND_BY_ID = "SELECT * " +
            "FROM cars WHERE CAR_ID = ?";
    private static final String SQL_FIND_BY_NAME = "SELECT car_id, make, model " +
            "FROM cars WHERE UPPER(make) ILIKE UPPER(?) OR UPPER(model) ILIKE UPPER(?)";



    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public Car findById(Integer car_id) {

           return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[]{car_id}, carRowMapper);


    }

    @Override
    public List<Map<String, Object>> findByName(String keyWord) {
        String searchTerm = "%" + keyWord + "%";

        return jdbcTemplate.query(SQL_FIND_BY_NAME, new Object[]{searchTerm, searchTerm}, new ColumnMapRowMapper());
    }





    private RowMapper<Car> carRowMapper = ((rs, rowNum) -> {
        return new Car(rs.getInt("CAR_ID"),
                rs.getString("MAKE"),
                rs.getString("MODEL"),
                rs.getString("BODY_TYPE"),
                rs.getString("ENGINE"),
                rs.getString("TRANSMISSION"),
                rs.getString("DRIVETRAIN"),
                rs.getInt("PASSENGERS"),
                rs.getInt("DOORS"),
                rs.getString("FUEL_TYPE"),
                rs.getFloat("CITY_MPG"),
                rs.getFloat("HIGHWAY_MPG"),
                rs.getDouble("PRICE")
        );
    });
}
