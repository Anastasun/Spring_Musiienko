package com.anastasiia.spring_musiienko.service;


import com.anastasiia.spring_musiienko.model.Review;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ReviewService {

    public List<Review> getAllReviews() {
        // Логіка для отримання всіх відгуків (наприклад, з БД або API)
        return List.of(new Review()); // Пример
    }

    public void exportReviewsToExcel() {
        List<Review> reviews = getAllReviews();

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Reviews");
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Book Title");
        headerRow.createCell(1).setCellValue("Review Text");
        headerRow.createCell(2).setCellValue("Sentiment");

        int rowNum = 1;
        for (Review review : reviews) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(review.getBookTitle());
            row.createCell(1).setCellValue(review.getReviewText());
            row.createCell(2).setCellValue(review.getSentiment());
        }

        try (FileOutputStream fileOut = new FileOutputStream("reviews.xlsx")) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String analyzeSentiment(String reviewText) {
        // Placeholder for sentiment analysis logic
        // Call to external API or use NLP library
        if (reviewText.contains("good")) {
            return "positive";
        } else if (reviewText.contains("bad")) {
            return "negative";
        } else {
            return "neutral";
        }
    }

}
