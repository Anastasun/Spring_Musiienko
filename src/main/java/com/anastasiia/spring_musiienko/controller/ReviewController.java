package com.anastasiia.spring_musiienko.controller;

import com.anastasiia.spring_musiienko.model.Review;
import com.anastasiia.spring_musiienko.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviews")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    // API для генерації Excel звіту
    @GetMapping("/export/excel")
    public void exportReviewsToExcel() {
        reviewService.exportReviewsToExcel();
    }
}
