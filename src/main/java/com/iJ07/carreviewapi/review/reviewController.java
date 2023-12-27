package com.iJ07.carreviewapi.review;


import com.iJ07.carreviewapi.car.Car;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Map;

@RestController
@RequestMapping("/carapi/car-review")
public class reviewController {
     @Autowired
     reviewService ReviewService;



    @GetMapping("/allReviews")
    public ResponseEntity<Object> getAllReviews() {

        Review review = ReviewService.fetchAllReviews();
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @PutMapping("/update/{reviewId}")
    public ResponseEntity<String> updateCategory(HttpServletRequest request,
                                                               @PathVariable("reviewId") Integer reviewId,
                                                               @RequestBody Review review) {

        String response = ReviewService.updateReview(reviewId, review);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity<String> addCategory(@RequestBody Map<String, Object> reviewMap) {
        int userId = (Integer) reviewMap.get("userId");
        int carId = (Integer) reviewMap.get("carId");
        int rating = (Integer) reviewMap.get("rating");
        String review_text = (String) reviewMap.get("review_text");

        String message = ReviewService.addReview(userId, carId, rating, review_text);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{reviewId}")
    public ResponseEntity<String> deleteCategory(HttpServletRequest request,
                                                               @PathVariable("reviewId") Integer reviewId) {

        String response = ReviewService.removeReviewById(reviewId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }



}
