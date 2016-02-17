package com.example.pannam.retrofitdemo2.model;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by pannam on 2/17/2016.
 */

// we are sorting flower so its the model
//To serialize an object means to convert its state to a
//  byte stream so that the byte stream can be reverted back into a copy of the object.

public class Flower implements Serializable {

//    category: "Shrubs",
//    price: 15.99,
//    instructions: "Large double. Good grower, heavy bloomer. Early to mid-season, acid loving plants. Plant in moist well drained soil with pH of 4.0-5.5.",
//    photo: "california_snow.jpg",
//    name: "Azalea",
//    productId: 1

    //Json is included so we need to this
    //to convert JSON to JAVA add Expose
    @Expose
    private String category;

    @Expose
    private double price;

    @Expose
    private String instruction;

    @Expose
    private String photo;

    @Expose
    private String name;

    @Expose
    private int productId;


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
