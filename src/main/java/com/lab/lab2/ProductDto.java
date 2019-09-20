package com.lab.lab2;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {
    private int id;
    private String name;
    private Float price;
    private Boolean availability;
    private String category;
    private String description;
    private Boolean by_weight;
    private String shop_name;
    private int shop_id;
}
