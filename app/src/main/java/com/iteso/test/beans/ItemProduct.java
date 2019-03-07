package com.iteso.test.beans;

public class ItemProduct {
    private int image;
    private String title;
    private String store;
    private String location;
    private String phone;
    private String description;

    public ItemProduct() {
        setImage(0);
        setTitle("");
        setStore("");
        setLocation("");
        setPhone("");
        setDescription("");
    }

    @Override
    public String toString() {
        return "ItemProduct{" +
                "\nimage=" + image +
                ", \ntitle='" + title + '\'' +
                ", \nstore='" + store + '\'' +
                ", \nlocation='" + location + '\'' +
                ", \nphone='" + phone + '\'' +
                ", \ndescription='" + description + '\'' +
                '}';
    }

    public ItemProduct(int image, String title, String store, String location, String phone, String description) {
        setImage(image);
        setTitle(title);
        setStore(store);
        setLocation(location);
        setPhone(phone);
        setDescription(description);
    }

    public String getName() {
        return title;
    }

    public void setName(String name) {
        this.title = name;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
