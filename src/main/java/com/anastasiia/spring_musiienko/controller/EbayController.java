package com.anastasiia.spring_musiienko.controller;


import com.anastasiia.spring_musiienko.dto.EbayItem;
import com.anastasiia.spring_musiienko.service.EbayService;
import com.anastasiia.spring_musiienko.service.ExcelService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EbayController {

    private final EbayService ebayService;
    private final ExcelService excelService;

    public EbayController(EbayService ebayService, ExcelService excelService) {
        this.ebayService = ebayService;
        this.excelService = excelService;
    }

    @GetMapping("/parse-ebay")
    public ResponseEntity<List<EbayItem>> parseEbay(@RequestParam String searchQuery) {
        List<EbayItem> ebayItems = ebayService.getEbayData(searchQuery);
        return ResponseEntity.ok(ebayItems);
    }

    @GetMapping("/download-excel")
    public ResponseEntity<byte[]> downloadExcel(@RequestParam String searchQuery) {
        List<EbayItem> ebayItems = ebayService.getEbayData(searchQuery);
        byte[] excelFile = null;

        try {
            excelFile = excelService.generateExcelReport(ebayItems);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=ebay_report.xlsx");

        return ResponseEntity.ok()
                .headers(headers)
                .body(excelFile);
    }
}
