package com.codecool.adfinder.data;

import javax.persistence.*;

@Entity
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true)
    private String url;
    private String street;
    @Column(length = 6000)
    private String description;
    private String publishTime;
    private Integer price;
    private Integer rooms;
    private String title;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStreet() {

        return street;
    }

    public String getDescription() {
        return description;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getRooms() {
        return rooms;
    }

    public String getTitle() {
        return title;
    }
}