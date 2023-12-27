package com.iJ07.carreviewapi.review;

import com.iJ07.carreviewapi.auth.User;
import com.iJ07.carreviewapi.car.Car;
import com.iJ07.carreviewapi.exceptions.EtAuthException;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.logging.Logger;

@Repository
public class reviewRepositoryImpl implements reviewRepository {

    private static final String SQL_CREATE = "INSERT INTO CAR_REVIEWS (review_id, car_id, user_id, rating, review_text, created_at, updated_at) VALUES(NEXTVAL('car_reviews_seq'), ?, ?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
    private static final String SQL_GET = "Select * from car_reviews;";

    private static final String SQL_UPDATE = "UPDATE CAR_REVIEWS SET rating = ?, review_text = ?, updated_at = CURRENT_TIMESTAMP WHERE REVIEW_ID = ?;";

    private static final String SQL_DELETE = "DELETE FROM CAR_REVIEWS WHERE REVIEW_ID = ?;";

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public String addReview(int userId, int carId, int rating, String review_text) {
        try {

            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, carId);
                ps.setInt(2, userId);
                ps.setInt(3, rating);
                ps.setString(4, review_text);
                return ps;
            });
            // Access the generated key

            return "Review Posted Successfully with ID: ";
        } catch (DataAccessException e) {
            // Log the exception and provide a more informative message
            System.out.println(e);
            return "Review did not post";
        }
    }

    @Override
    public Review getAllReviews() {
        try {
           Review review = jdbcTemplate.queryForObject(SQL_GET,  reviewRowMapper);

            return review;
        }catch (EmptyResultDataAccessException e) {
            throw new EtAuthException("No Reviews to get");
        }
    }

    @Override
    public String updateReview(int reviewId,  Review review) {

        try {
            System.out.println(review.getReviewText());
            jdbcTemplate.update(SQL_UPDATE, new Object[]{review.getRating(), review.getReviewText(), reviewId});
            return "Review Updated Successfully";
        }
        catch (DataAccessException e) {
            System.out.println(e);
            return "Did not update successfully";
        }

    }

    @Override
    public String removeReviewById(int reviewId) {
        try {
            jdbcTemplate.update(SQL_DELETE, new Object[]{reviewId});
            return "Deleted Successfully";
        }
        catch (DataAccessException e) {
            return "Did not delete successfully";
        }
    }


    private RowMapper<Review> reviewRowMapper = ((rs, rowNum) -> {
        return new Review(rs.getInt("REVIEW_ID"),
                rs.getInt("CAR_ID"),
                rs.getInt("USER_ID"),
                rs.getInt("RATING"),
                rs.getString("REVIEW_TEXT"),
                rs.getString("CREATED_AT"),
                rs.getString("UPDATED_AT")

        );
    });
}
