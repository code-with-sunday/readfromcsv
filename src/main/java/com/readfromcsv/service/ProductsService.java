package com.readfromcsv.service;

import com.readfromcsv.readfromcsv.Products;

import java.util.List;

public interface ProductsService {

    String buyProducts(List<Products> productsList, String productCategory, int quantityToBuy);
}
