package com.iJ07.carreviewapi.review;

import java.sql.Timestamp;

public interface reviewRepository {

   String addReview (int userId, int carId, int rating, String review_text);

   Review getAllReviews();

   String updateReview(int reviewId,  Review review);

   String removeReviewById (int reviewId);
}
