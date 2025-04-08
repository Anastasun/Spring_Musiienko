package com.anastasiia.spring_musiienko.service;

import com.anastasiia.spring_musiienko.dto.EbayItem;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EbayService {

    private static final Logger logger = LoggerFactory.getLogger(EbayService.class);

    public List<EbayItem> getEbayData(String searchQuery) {
        String url = "https://www.ebay.com/sch/i.html?_nkw=" + searchQuery;
        List<EbayItem> items = new ArrayList<>();

        try {
            logger.info("Connecting to eBay with search query: {}", searchQuery);
            Document doc = Jsoup.connect(url).get();
            Elements itemElements = doc.select(".s-item");

            for (Element item : itemElements) {
                String title = item.select(".s-item__title").text();
                String price = item.select(".s-item__price").text();

                if (!title.isEmpty() && !price.isEmpty()) {
                    items.add(new EbayItem(title, price));
                }
            }

            if (items.isEmpty()) {
                throw new IOException("No items found.");
            }

        } catch (IOException e) {
            logger.error("Error while parsing eBay data", e);
            throw new RuntimeException("Error parsing eBay data: " + e.getMessage());
        }

        logger.info("Found {} items", items.size());
        return items;
    }
}
