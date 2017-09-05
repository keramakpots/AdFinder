package com.codecool.adfinder.user;

import com.codecool.adfinder.data.ExtendAd;
import com.codecool.adfinder.user.request.UserRequest;
import com.codecool.adfinder.user.response.UserResponse;
import com.google.maps.errors.ApiException;

import java.io.IOException;
import java.util.List;

public interface IUserResponseFactory {
    UserResponse from(UserRequest userRequest) throws InterruptedException, ApiException, IOException;
}
