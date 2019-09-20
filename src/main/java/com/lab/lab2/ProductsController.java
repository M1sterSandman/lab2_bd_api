package com.lab.lab2;


import com.lab.lab2.entity.Product;
import com.lab.lab2.repository.ProductRepository;
import com.lab.lab2.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("products")
public class ProductsController {

    private ProductRepository productRepository;
    private ShopRepository shopRepository;

    @Autowired
    public ProductsController(ProductRepository productRepository, ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductDto> getProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("add")
    public ProductDto addProduct(@RequestBody ProductDto productDto) {
        productRepository.save(fromDto(productDto));
        return productDto;
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productRepository.deleteById(id);
    }

    public Product fromDto(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setCategory(productDto.getCategory());
        product.setAvailability(productDto.getAvailability());
        product.setPrice(productDto.getPrice());
        product.setBy_weight(productDto.getBy_weight());
        product.setShopId(shopRepository.getOne(productDto.getShop_id()).getId()
        );

        return product;
    }

    public ProductDto toDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setCategory(product.getCategory());
        productDto.setDescription(product.getDescription());
        productDto.setAvailability(product.getAvailability());
        productDto.setPrice(product.getPrice());
        productDto.setShop_name(shopRepository.getOne(product.getShopId()).getName());
        productDto.setBy_weight(product.getBy_weight());

        return productDto;
    }
}
