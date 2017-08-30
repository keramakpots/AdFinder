package com.codecool.adfinder.user;

import com.codecool.adfinder.data.Ad;

import java.util.ArrayList;
import java.util.List;

public class ResultGetter {
    List<Ad> adToProcessing;

    public ResultGetter(List<Ad> adToProcessing) {
        this.adToProcessing = adToProcessing;
    }

    public List<Ad> getAdToProcessing() {
        for (int i = 0; i < adToProcessing.size(); i++) {
            if(adToProcessing.get(i).getStreet() == null) {
                adToProcessing.remove(i);
            }
        }
        return adToProcessing;
    }
}
