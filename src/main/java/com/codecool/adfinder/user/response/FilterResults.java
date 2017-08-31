package com.codecool.adfinder.user.response;

import com.codecool.adfinder.data.Ad;
import com.codecool.adfinder.data.ExtendAd;
import com.codecool.adfinder.user.request.UserRequest;
import com.google.maps.errors.ApiException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
            if (ad.getPrice() < userRequest.getMaxPrice() && ad.getRooms() == userRequest.getRooms()) {
                extendAdList.add(new ExtendAd(ad, userRequest));
            }
        }
    }

    public List<ExtendAd> getFiltredResults() {
        for (int i = 0; i < extendAdList.size(); i++) {
            if (extendAdList.get(i).getDistance() > userRequest.getMaxDistance() || extendAdList.get(i).getDuration() > userRequest.getMaxDuration()) {
                extendAdList.remove(i);
            }
        }
        return extendAdList;
    }

}
