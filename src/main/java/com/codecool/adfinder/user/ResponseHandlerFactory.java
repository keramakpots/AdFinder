package com.codecool.adfinder.user;

import com.codecool.adfinder.data.Ad;
import com.codecool.adfinder.data.AdServices;
import com.codecool.adfinder.data.ExtendAd;
import com.codecool.adfinder.user.request.UserRequest;
import com.codecool.adfinder.user.response.FilterResults;
import com.google.maps.errors.ApiException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class ResponseHandlerFactory implements IResponseHandlerFactory {
    public ResponseHandlerFactory() {
    }



    @Override

    public List<ExtendAd> from(AdServices adServices, UserRequest userRequest) throws InterruptedException, ApiException, IOException {
        List<Ad> adList = adServices.getAdsByMinPriceAndMaxPriceAndRooms(userRequest.getMinPrice(), userRequest.getMaxPrice(), userRequest.getRooms());
        FilterResults filterResults = new FilterResults(userRequest, adList);
        return filterResults.getFilteredResults();
    }
}