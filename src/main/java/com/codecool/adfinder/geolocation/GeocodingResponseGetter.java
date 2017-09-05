package com.codecool.adfinder.geolocation;

import com.codecool.adfinder.user.request.UserRequest;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixElement;
import com.google.maps.model.DistanceMatrixRow;

public class GeocodingResponseGetter {
    private DistanceMatrix distanceMatrix;
    private UserRequest userRequest;
    private long distance;
    private long duration;

    public GeocodingResponseGetter(DistanceMatrix distanceMatrix) throws NullPointerException {
        this.distanceMatrix = distanceMatrix;
        getResponseData();
    }

    public long getDistance() {
        return distance;
    }

    public long getDuration() {
        return duration;
    }

    private void getResponseData() throws NullPointerException {
        for (DistanceMatrixRow row : distanceMatrix.rows) {
            for (DistanceMatrixElement element : row.elements
                    ) {
                duration = element.duration.inSeconds;
                distance = element.distance.inMeters;
            }
        }
    }

}
