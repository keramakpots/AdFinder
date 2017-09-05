package com.codecool.adfinder.data;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

@Component
public class AdBuilder {
    private String url;
    private String street;
    @Length(max = 5000)
    private String description;
    private String publishTime;
    private Integer price;
    private Integer rooms;
    private String title;

    public AdBuilder url(String url) {
        this.url = url;
        return this;
    }

    public AdBuilder street(String street) {
        this.street = street;
        return this;
    }

    public AdBuilder description(String description) {
        this.description = description;
        return this;
    }

    public AdBuilder publishTime(String publishTime) {
        this.publishTime = publishTime;
        return this;
    }

    public AdBuilder price(Integer price) {
        this.price = price;
        return this;
    }

    public AdBuilder rooms(Integer rooms) {
        this.rooms = rooms;
        return this;
    }

    public AdBuilder title(String title) {
        this.title = title;
        return this;
    }

    public Ad build() {
        return new Ad(this);
    }


}