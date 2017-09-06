package com.codecool.adfinder.geolocation;

import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import java.io.IOException;

public class GeocodingRequestSender {

    GeocodingRequestCreator requestCreator;

    public GeocodingRequestSender(GeocodingRequestCreator reqeuestCreator) {
        this.requestCreator = reqeuestCreator;
    }

    public DistanceMatrix sendGeocodingRequest()
        throws InterruptedException, ApiException, IOException {
        return requestCreator.getRequestBuilder().await();
    }
}

