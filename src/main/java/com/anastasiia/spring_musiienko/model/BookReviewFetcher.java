package com.anastasiia.spring_musiienko.model;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookReviewFetcher {

    private static final String GOODREADS_API_URL = "https://api.goodreads.com/review/list";

    // Example of fetching reviews (you'll need API key for actual implementation)
    public List<Review> fetchReviewsFromGoodreads(String bookId) {
        // Implement API call and parse response
        // Returning dummy data for now
        Review review = new Review();
        review.setBookTitle("Example Book");
        review.setReviewText("This is an amazing book!");
        review.setSentiment("positive");
        return List.of(review);
    }
}