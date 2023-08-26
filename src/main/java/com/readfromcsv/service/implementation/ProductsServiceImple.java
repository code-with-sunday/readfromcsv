package com.readfromcsv.service.implementation;

import com.readfromcsv.readfromcsv.Products;
import com.readfromcsv.service.ProductsService;

import java.util.List;

public class ProductsServiceImple implements ProductsService {


    @Override
    public String buyProducts(List<Products> productsList, String productCategory, int quantityToBuy) {
        if (quantityToBuy < 0) {
            return "Invalid quantity to buy: " + quantityToBuy;
        }
        for (Products product : productsList) {
            if (product.getProductCategory().equals(productCategory)) {
                if (product.getQuantity() >= quantityToBuy) {
                    int newupdatedQuantity = product.getQuantity() - quantityToBuy;
                    product.updateQuantity(newupdatedQuantity);
                    System.out.println("Bought " + quantityToBuy + " " + productCategory);
                    return "Bought " + quantityToBuy + " " + productCategory; // Exit the loop once the product is found and updated
                } else {
                    System.out.println("Insufficient quantity of " + productCategory + " to buy.");
                    return "Insufficient quantity of " + productCategory + " to buy."; // Exit the loop if quantity is insufficient
                }
            }
        }
        return "Product category not found: " + productCategory;
    }
}


