package com.readfromcsv.readfromcsv;

public class Products {
    private int id;
    private  String guid;
    private String productCategory;
    private double price;
    private int quantity;

    public Products(int id, String guid, String productCategory, double price, int quantity) {
        this.id = id;
        this.guid = guid;
        this.productCategory = productCategory;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getGuid() {
        return guid;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void updateQuantity(int quantityToBuy) {
        this.quantity -= quantityToBuy;
    }



    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", guid='" + guid + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
