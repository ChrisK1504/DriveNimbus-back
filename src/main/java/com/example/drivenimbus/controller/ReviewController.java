package com.example.drivenimbus.controller;

import com.example.drivenimbus.dto.ReviewDTO;
import com.example.drivenimbus.model.Review;
import com.example.drivenimbus.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;
//    | Endpoint                     | Controller         | Responsibility             |
//            | ---------------------------- | ------------------ | -------------------------- |
//            | `POST /cars/{carId}/reviews` | `ReviewController` | Add a review for a car     |
//            | `GET /cars/{carId}/reviews`  | `ReviewController` | List all reviews for a car |
//            | `PUT /reviews/{reviewId}`    | `ReviewController` | Update a specific review   |
//            | `DELETE /reviews/{reviewId}` | `ReviewController` | Delete a specific review   |

    @Operation(summary = "Create a new review for a carID, with a specified userID")
    @PostMapping("/cars/{carId}")
    public ResponseEntity<Review> addReview(@RequestBody ReviewDTO reviewDTO, @PathVariable Long carId, @RequestParam Long userId) {
        Review newReview = reviewService.saveReview(reviewDTO, carId, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body( newReview );
    }

    @Operation(summary = "List all reviews for a carID")
    @GetMapping("/cars/{carId}")
    public ResponseEntity<List<Review>> getReviewsByCarId(@PathVariable Long carId) {
        List<Review> reviews = reviewService.fetchReviewsByCarId(carId);
        return reviews.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(reviews);
    }

    @Operation(summary = "Update a review directly using reviewID")
    @PutMapping("/{reviewId}")
    public ResponseEntity<Review> updateReview(@RequestBody ReviewDTO reviewDTO, @PathVariable Long reviewId) {
        Review updatedReview = reviewService.saveReview(reviewDTO, reviewId, null);
        if (updatedReview != null) {
            return ResponseEntity.ok(updatedReview);
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Delete a review directly using reviewID")
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long reviewId) {
        if (reviewService.deleteReviewById(reviewId)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "List all reviews for a userID")
    @GetMapping("users/{userId}")
    public ResponseEntity<List<Review>> getReviewByUserId(@PathVariable Long userId) {
        List<Review> reviewList = reviewService.fetchReviewsByCarId(userId);
        return reviewList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(reviewList);
    }

    @Operation(summary = "General fetch operation to use with query parameters")
    @GetMapping
    public ResponseEntity<List<Review>> getReviewByCarIdAndUserId(@RequestParam(required = false) Long userId, @RequestParam(required = false) Long carId) {
        if (carId != null && userId != null) {
            return ResponseEntity.ok(reviewService.fetchReviewsByCarIdAndUserId(carId, userId));
        } else if (carId != null) {
            return ResponseEntity.ok(reviewService.fetchReviewsByCarId(carId));
        } else if (userId != null) {
            return ResponseEntity.ok(reviewService.fetchReviewsByUserId(userId));
        } else {
            return ResponseEntity.ok(reviewService.fetchAllReviews());
        }
    }


}
