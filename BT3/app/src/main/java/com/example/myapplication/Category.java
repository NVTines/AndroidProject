package com.example.myapplication;

public class Category {
    private String title;
    private String description;
    private String date;
    private String link;
    private String img;


    public Category() {
    }

    public Category(String title, String description, String date, String link, String img) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.link = link;
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
