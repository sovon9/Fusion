package com.sovon9.ActivityService;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ReviewController {

    private static final List<Review> REVIEWS = List.of(
            new Review("1", 5, "Great product!"),
            new Review("1", 4, "Pretty good"),
            new Review("2", 2, "Not satisfied")
    );

    @QueryMapping
    public List<Review> reviews()
    {
        return REVIEWS;
    }

    @QueryMapping
    public List<Review> reviewsByProductId(@Argument String productId) {
        return REVIEWS.stream()
                .filter(r -> r.getProductId().equals(productId))
                .collect(Collectors.toList());
    }

    // For resolving 'reviews' on Product via @lookup(by: "productId")
    @SchemaMapping(typeName = "Product", field = "reviews")
    public List<Review> reviews(Product product) {
        return REVIEWS.stream()
                .filter(r -> r.getProductId().equals(product.getId()))
                .collect(Collectors.toList());
    }

}
