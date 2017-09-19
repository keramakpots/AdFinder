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

    public static final class AdBuilder {

        private String url;
        private String street;
        private String description;
        private String publishTime;
        private Integer price;
        private Integer rooms;
        private String title;

        private AdBuilder() {
        }

        public static AdBuilder anAd() {
            return new AdBuilder();
        }

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
            Ad ad = new Ad();
            ad.setUrl(url);
            ad.setStreet(street);
            ad.setDescription(description);
            ad.setPublishTime(publishTime);
            ad.setPrice(price);
            ad.setRooms(rooms);
            ad.setTitle(title);
            return ad;
        }
    }
}