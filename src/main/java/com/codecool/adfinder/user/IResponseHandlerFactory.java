package com.codecool.adfinder.user;

import com.codecool.adfinder.data.AdServices;
import com.codecool.adfinder.data.ExtendAd;
import com.codecool.adfinder.user.request.UserRequest;
import com.google.maps.errors.ApiException;

import java.io.IOException;
import java.util.List;

public interface IResponseHandlerFactory {
    List<ExtendAd> from(AdServices adServices, UserRequest request) throws InterruptedException, ApiException, IOException;
}
