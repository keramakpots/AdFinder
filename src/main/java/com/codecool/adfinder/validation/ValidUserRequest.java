package com.codecool.adfinder.validation;

import com.codecool.adfinder.user.request.UserRequest;

public class ValidUserRequest {

    private UserRequest userRequest;

    public ValidUserRequest(UserRequest userRequest) {
        this.userRequest = userRequest;
    }


    public UserRequest validRequest() {
        if (userRequest.getMinPrice().equals(null)) {
            userRequest.setMinPrice(0);
        }
        if (userRequest.getMaxPrice().equals(null)) {
            userRequest.setMaxPrice(1000000);
        }
        if (userRequest.getRooms().equals(null)) {
            userRequest.setRooms(1);
        }
        if (userRequest.getMaxDistance().equals(null)) {
            userRequest.setMaxDistance(10000);
        }
        if (userRequest.getMaxDuration().equals(null)) {
            userRequest.setMaxDuration(10000);
        }
        return userRequest;
    }
}
