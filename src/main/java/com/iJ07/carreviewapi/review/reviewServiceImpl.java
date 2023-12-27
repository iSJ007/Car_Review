package com.iJ07.carreviewapi.review;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Service
@Transactional
public class reviewServiceImpl implements reviewService{

    @Autowired
    reviewRepository ReviewRepository;


    @Override
    public Review fetchAllReviews() {
        return ReviewRepository.getAllReviews();
    }

    @Override
    public String addReview(int userId, int carId, int rating, String review_text) {
        return ReviewRepository.addReview(userId, carId, rating, review_text);
    }

    @Override
    public String updateReview(int reviewId, Review review) {
      return ReviewRepository.updateReview(reviewId,  review);
    }

    @Override
    public String removeReviewById(int reviewId) {
        return ReviewRepository.removeReviewById(reviewId);
    }
}
