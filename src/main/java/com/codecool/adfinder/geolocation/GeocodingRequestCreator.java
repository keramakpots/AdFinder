package com.codecool.adfinder.geolocation;

import com.codecool.adfinder.user.request.UserRequest;
import com.google.maps.DirectionsApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.TravelMode;
import com.google.maps.model.Unit;

import java.util.Objects;

public class GeocodingRequestCreator {
    private UserRequest userRequest;
    private DistanceMatrixApiRequest requestBuilder;
    private TravelType travelType;
    private String startingStreet;
    private final String apiKey = "AIzaSyCYyk6zbit2ywq5Xgxray_C147oelow5Hw";
    private final GeoApiContext context = new GeoApiContext.Builder()
            .apiKey(apiKey)
            .build();

    // TODO: 30/08/2017 inseted of staringStreet insert ExtendAd
    public GeocodingRequestCreator(UserRequest userRequest, String startingStreet) {
        this.userRequest = userRequest;
        this.startingStreet = startingStreet;
    }

    public void createMatrixApi() {
        requestBuilder = new DistanceMatrixApiRequest(context);
        addUserPAramsToRequest(requestBuilder);
        setBasicRequestParams(requestBuilder);
    }

    public DistanceMatrixApiRequest getRequestBuilder() {
        return requestBuilder;
    }

    private void addUserPAramsToRequest(DistanceMatrixApiRequest request) {
        addTravelModes(request);

    }

    private void addTravelModes(DistanceMatrixApiRequest request) {
        if (Objects.equals(userRequest.getTravelType(), "BICYCLING")) {
            travelType = TravelType.BICYCLING;
            request.mode(TravelMode.BICYCLING);
        }
        if (Objects.equals(userRequest.getTravelType(), "DRIVING")) {
            travelType = TravelType.DRIVING;
            request.mode(TravelMode.DRIVING);
        }
        if (Objects.equals(userRequest.getTravelType(), "WALKING")) {
            travelType = TravelType.WALKING;
            request.mode(TravelMode.WALKING);
        }
    }

    private void setBasicRequestParams(DistanceMatrixApiRequest request) {
        request.language("pl")
                .avoid(DirectionsApi.RouteRestriction.TOLLS)
                .units(Unit.METRIC)
                .origins(startingStreet + ", Kraków, Polska")
                .destinations(userRequest.getStreet() + ", Kraków, Polska");
    }
}
