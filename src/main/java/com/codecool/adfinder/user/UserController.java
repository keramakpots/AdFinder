package com.codecool.adfinder.user;

import com.codecool.adfinder.data.AdServices;
import com.codecool.adfinder.data.ExtendAd;
import com.google.gson.Gson;
import com.google.maps.DirectionsApi;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.TravelMode;
import com.google.maps.model.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private AdServices adServices;

//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public @ResponseBody
//    Map<String, Object> getAds(@RequestBody UserRequest request) {
//        return (Map<String, Object>) request;
//    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody
    String getAds(@RequestBody UserRequest request) throws InterruptedException, ApiException, IOException {
        ResponseHandler responseHandler = new ResponseHandler();
        List<ExtendAd> result = responseHandler.getResult(adServices, request);
        UserResponse userResponse = new UserResponse(result);
        return new Gson().toJson(userResponse);
    }
}
