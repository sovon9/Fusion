package com.sovon9.ActivityService;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductController {

    private static final List<Product> PRODUCTS = List.of(
            new Product("1", "AA"),
            new Product("2", "BB")
    );
    private static final List<Review> reviews = List.of(
            new Review("1", 5, "Excellent"),
            new Review("1", 4, "Very Good"),
            new Review("2", 3, "Average")
    );

    @QueryMapping
    public List<Product> products()
    {
        return PRODUCTS;
    }

    @QueryMapping
    public Product productById(@Argument String id) {
        return PRODUCTS.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @QueryMapping
    public List<Review> reviews() {
        return reviews;
    }

    @QueryMapping
    public List<Review> reviewsByProductId(@Argument String productId) {
        return reviews.stream()
                .filter(r -> r.getProductId().equals(productId))
                .toList();
    }

    @SchemaMapping(typeName = "Product", field = "reviews")
    public List<Review> getReviews(Product product) {
        return reviews.stream()
                .filter(r -> r.getProductId().equals(product.getId()))
                .toList();
    }

}
