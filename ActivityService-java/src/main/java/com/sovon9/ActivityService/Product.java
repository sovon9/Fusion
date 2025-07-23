package com.sovon9.ActivityService;

import java.util.List;

public class Product {
    private String id;
    private String name;
    private List<Review> reviews;
    public Product() {
    }

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Review> getReview() {
        return reviews;
    }

    public void setReview(List<Review> review) {
        this.reviews = review;
    }
}
