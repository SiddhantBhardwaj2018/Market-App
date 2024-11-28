package com.siddhantbhardwaj.marketapp;

public class Item {

    int image;
    String itemName;
    String itemDesc;

    public Item(int image, String itemName, String itemDesc) {
        this.image = image;
        this.itemName = itemName;
        this.itemDesc = itemDesc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }
}
