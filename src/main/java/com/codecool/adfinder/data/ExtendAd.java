package com.codecool.adfinder.data;

import com.codecool.adfinder.geolocation.GeocodingRequestCreator;
import com.codecool.adfinder.geolocation.GeocodingRequestSender;
import com.codecool.adfinder.geolocation.GeocodingResponseGetter;
import com.codecool.adfinder.user.request.UserRequest;
import com.google.maps.errors.ApiException;

import java.io.IOException;

public class ExtendAd extends Ad {
    private Ad ad;
    private String destinationStreet;
    private Integer duration;
    private Integer distance;

    public ExtendAd(Ad ad, UserRequest userRequest) throws InterruptedException, ApiException, IOException {
        super();
        this.ad = ad;
        setExtendsFields(userRequest);
    }

    public String getDestinationStreet() {
        return destinationStreet;
    }

    public long getDuration() {

        return duration;
    }

    public long getDistance() {
        return distance;
    }


    @Override
    public String getUrl() {
        return ad.getUrl();
    }

    @Override
    public String getStreet() {
        return ad.getStreet();
    }

    @Override
    public String getDescription() {
        return ad.getDescription();
    }

    @Override
    public String getPublishTime() {
        return ad.getPublishTime();
    }

    @Override
    public Integer getPrice() {
        return ad.getPrice();
    }

    @Override
    public Integer getRooms() {
        return ad.getRooms();
    }

    @Override
    public String getTitle() {
        return ad.getTitle();
    }

    private void setExtendsFields(UserRequest userRequest) throws InterruptedException, ApiException, IOException {
        GeocodingRequestCreator requestCreator = new GeocodingRequestCreator(userRequest, ad.getStreet());
        requestCreator.createMatrixApi();
        GeocodingRequestSender requestSender = new GeocodingRequestSender(requestCreator);
        GeocodingResponseGetter responseGetter = new GeocodingResponseGetter(requestSender.sendGeocodingRequest());
        duration = Math.toIntExact(responseGetter.getDuration());
        distance = Math.toIntExact(responseGetter.getDistance());
    }
}
