package com.codecool.adfinder.user;

import com.codecool.adfinder.data.AdServices;
import com.codecool.adfinder.data.ExtendAd;
import com.codecool.adfinder.user.request.UserRequest;
import com.codecool.adfinder.user.response.UserResponse;
import com.google.maps.errors.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class UserResponseFactory implements IUserResponseFactory {
    public UserResponseFactory() {
    }

    @Autowired
    private IResponseHandlerFactory responseHandlerFactory;

    @Autowired
    private AdServices adService;

    @Override
    public UserResponse from(UserRequest userRequest) throws InterruptedException, ApiException, IOException {
        return new UserResponse(responseHandlerFactory.from(adService, userRequest));
    }
}