package com.shope.shopmart.Services;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.shope.shopmart.Entities.Product;
import com.shope.shopmart.Repository.ProductRepository;
import com.shope.shopmart.dtos.AddProductDto;
import com.shope.shopmart.dtos.UpdateProductDto;

@Service
public class ProductService {
    // private Map<Integer, Product> products = new HashMap<>();
    // private AtomicInteger counter = new AtomicInteger();

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(AddProductDto addProductDto) {
        Product product = new Product();
        // product.setId(counter.incrementAndGet());
        product.setProductName(addProductDto.getProductName());
        product.setManufacturingDate(addProductDto.getManufacturingDate());
        product.setManufacturer(addProductDto.getManufacturer());
        product.setPrice(addProductDto.getPrice());
        product.setDescription(addProductDto.getDescription());
        product.setImageUrl(addProductDto.getImageUrl());
        // products.put(product.getId(), product);
        productRepository.save(product);
        return product;
    }

    // GetAllProduct
    // public Collection<Product> getAllProducts() {
    // return this.products.values();
    // }
    public Iterable<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    // GetProductById
    public Product getProductById(Integer id) {
        Product product = this.productRepository.findById(id).orElseGet(null);
        if (product == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
        return product;
    }

    // UpdateProduct
    public Product updateProduct(Integer id, UpdateProductDto updateProductDto) {
        Product product = getProductById(id);
        if (updateProductDto.getProductName() != null) {
            product.setProductName(updateProductDto.getProductName());
        }
        if (updateProductDto.getDescription() != null) {
            product.setDescription(updateProductDto.getDescription());
        }
        if (updateProductDto.getManufacturer() != null) {
            product.setManufacturer(updateProductDto.getManufacturer());
        }
        if (updateProductDto.getManufacturingDate() != null) {
            product.setManufacturingDate(updateProductDto.getManufacturingDate());
        }
        if (updateProductDto.getPrice() != null) {
            product.setPrice(updateProductDto.getPrice());
        }
        if (updateProductDto.getImageUrl() != null) {
            product.setImageUrl(updateProductDto.getImageUrl());
        }
        return this.productRepository.save(product);

    }
    // DeleteProduct

    public void deleteProduct(Integer id) {
        Product product = this.getProductById(id);
        if (product == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
        
        // products.remove(id);
        this.productRepository.deleteById(id);
    }
        // GetByManufacturer
        public List<Product> getByManufacturer(String manufacturer) {
            return this.productRepository.findByManufacturer(manufacturer);
        }
    
        // GetByPrice
        public List<Product> getByPrice(Double price) {
            return this.productRepository.findByPriceLessThan(price);
        }
    
        // SortByName
        public List<Product> sortByName() {
            return this.productRepository.sortByName();
        }
    }
