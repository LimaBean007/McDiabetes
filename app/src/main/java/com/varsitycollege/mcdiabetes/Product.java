package com.varsitycollege.mcdiabetes;

public class Product {
    private String productName;
    private String productPrice;
private boolean hasLettuce;

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
