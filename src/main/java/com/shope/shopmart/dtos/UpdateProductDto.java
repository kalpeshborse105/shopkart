package com.shope.shopmart.dtos;

import java.time.Instant;

import lombok.Data;

@Data
public class UpdateProductDto {
    // @NotNull
    // @Size(min = 5, message = "Product name should that 5 or more characters")
    private String productName;
    // @NotNull
    // @PastOrPresent(message = "Manufacturing data should be either today's or past date")
    private Instant manufacturingDate;
    // @NotNull
    // @Size(min = 5, message = "Manufacturer name should that 5 or more character")
    private String manufacturer;
    // @NotNull
    // @Min(value = 1, message = "Price value should be more than 0")
    private Double price;
    // @NotNull
    // @Size(min = 5, message = "Description  should that 5 or more character")
    private String description;
    private String imageUrl;
}
