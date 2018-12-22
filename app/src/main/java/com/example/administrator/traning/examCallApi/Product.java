package com.example.administrator.traning.examCallApi;

public class Product {
    private String _id;
    private String produce;
    private String price;


    public Product(){}

    public Product(String produce, String price) {
        this.produce = produce;
        this.price = price;
    }

    public Product(String id, String produce, String price) {
        this._id = id;
        this.produce = produce;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + _id + '\'' +
                ", produce='" + produce + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getProduce() {
        return produce;
    }

    public void setProduce(String produce) {
        this.produce = produce;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
