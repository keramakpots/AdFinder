package com.codecool.adfinder.user;

import com.codecool.adfinder.data.ExtendAd;

import java.util.List;

public class UserResponse {
    private List<ExtendAd> adsList;

    public UserResponse(List<ExtendAd> adsList) {
        this.adsList = adsList;
    }

    public List<ExtendAd> getAdsList() {
        return adsList;
    }

    public void setAdsList(List<ExtendAd> adsList) {
        this.adsList = adsList;
    }
}
