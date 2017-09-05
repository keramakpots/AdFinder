package com.codecool.adfinder.user.response;

import com.codecool.adfinder.data.Ad;
import com.codecool.adfinder.data.ExtendAd;
import com.codecool.adfinder.user.request.UserRequest;
import com.google.maps.errors.ApiException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterResults {
    private UserRequest userRequest;
    private List<ExtendAd> extendAdList;

    public FilterResults(UserRequest userRequest, List<Ad> adList) throws InterruptedException, ApiException, IOException {
        this.userRequest = userRequest;
        setExtendAdList(userRequest, adList);
    }

    private void setExtendAdList(UserRequest userRequest, List<Ad> adList) throws InterruptedException, ApiException, IOException {
        extendAdList = new ArrayList<>();
        for (Ad ad :
                adList) {
            try {
                extendAdList.add(new ExtendAd(ad, userRequest));
            } catch (NullPointerException e) {
                System.out.println("Not found!");
            }
        }
    }

    public List<ExtendAd> getFilteredResults() {
        return extendAdList.stream()
                .filter(ad -> ad.getDuration() <= userRequest.getMaxDuration())
                .filter(ad -> ad.getDistance() <= userRequest.getMaxDistance())
                .collect(Collectors.toList());
    }

}
