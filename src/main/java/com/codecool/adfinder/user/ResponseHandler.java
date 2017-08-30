package com.codecool.adfinder.user;

import com.codecool.adfinder.data.Ad;
import com.codecool.adfinder.data.AdServices;
import com.codecool.adfinder.data.ExtendAd;
import com.google.maps.errors.ApiException;

import java.io.IOException;
import java.util.List;

public class ResponseHandler {
    public List<ExtendAd> getResult(AdServices adServices, UserRequest userRequest) throws InterruptedException, ApiException, IOException {
        List<Ad> list = adServices.getAdByParameters(userRequest.getMinPrice(), userRequest.getMaxPrice(), userRequest.getRooms());
        for (Ad ad :
                list) {
        }
        ResultGetter resultGetter = new ResultGetter(list);
        FilterResults filterResults = new FilterResults(userRequest, resultGetter.getAdToProcessing());
        return filterResults.getFiltredResults();
    }
}
