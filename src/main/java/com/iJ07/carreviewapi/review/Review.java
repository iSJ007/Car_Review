package com.iJ07.carreviewapi.review;

import java.sql.Timestamp;
import java.util.Date;

public class Review {

    private Integer review_id;
    private Integer car_id;
    private Integer user_id;
    private Integer rating;
    private String review_text;

    private String created_at;

    private String updated_at;

    public Review(Integer review_id, Integer car_id, Integer user_id, Integer rating, String review_text, String created_at, String updated_at) {
        this.review_id = review_id;
        this.car_id = car_id;
        this.user_id = user_id;
        this.rating = rating;
        this.review_text = review_text;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Integer getReviewId() {
        return review_id;
    }

    public Integer getCarId() {
        return car_id;
    }

    public Integer getUserId() {
        return user_id;
    }

    public Integer getRating() {
        return rating;
    }

    public String getReviewText() {
        return review_text;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }



}

