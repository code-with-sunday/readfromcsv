package com.readfromcsv.service.implementation;

import com.readfromcsv.readfromcsv.Products;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductsServiceImpleTest {

    private ProductsServiceImple productsService;
    private List<Products> productsList;

    @BeforeEach
    void setUp() {
        productsService = new ProductsServiceImple();
        productsList = new ArrayList<>();
    }

    @Test
    void testBuyProductsSufficientQuantity() {
        Products product = new Products(1, "guid1", "TestProduct", 10.0, 10);
        productsList.add(product);

        String result = productsService.buyProducts(productsList, "TestProduct", 5);

        assertEquals("Bought 5 TestProduct", result);
        assertEquals(5, product.getQuantity());
    }

    @Test
    void testBuyProductsInsufficientQuantity() {
        Products product = new Products(1, "guid1", "TestProduct", 10.0, 3);
        productsList.add(product);

        String result = productsService.buyProducts(productsList, "TestProduct", 5);

        assertEquals("Insufficient quantity of TestProduct to buy.", result);
        assertEquals(3, product.getQuantity());
    }

    @Test
    void testBuyProductsCategoryNotFound() {
        Products product = new Products(1, "guid1", "TestProduct", 10.0, 10);
        productsList.add(product);

        String result = productsService.buyProducts(productsList, "OtherProduct", 5);

        assertEquals("Product category not found: OtherProduct", result);
    }

    @Test
    void testBuyProductsNegativeQuantity() {
        Products product = new Products(1, "guid1", "TestProduct", 10.0, 10);
        productsList.add(product);

        String result = productsService.buyProducts(productsList, "TestProduct", -5);

        assertEquals("Invalid quantity to buy: -5", result);
        assertEquals(10, product.getQuantity());
    }
}
