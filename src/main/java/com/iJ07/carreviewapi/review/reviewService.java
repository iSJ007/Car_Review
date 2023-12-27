package com.iJ07.carreviewapi.review;

import java.sql.Timestamp;

public interface reviewService {

    Review fetchAllReviews ();

    String addReview (int userId, int carId, int rating, String review_text);

    String updateReview (int reviewId,  Review review);

    String removeReviewById (int reviewId);
}
