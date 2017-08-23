package com.codecool.adfinder.parser.olx;

import com.codecool.adfinder.data.Ad;
import com.codecool.adfinder.parser.olx.sourcegetter.HtmlDataGetter;

import java.util.ArrayList;
import java.util.List;

public class HtmlToAdConverter {
    private List<HtmlDataGetter> htmlData;

    public HtmlToAdConverter(List<HtmlDataGetter> htmlData) {
        this.htmlData = htmlData;
    }

    public List<Ad> getAdFromSource(){
        List<Ad> ads = new ArrayList<>();
        for ( HtmlDataGetter source : htmlData ){
            Ad ad = new Ad();
            ad.setDescription(source.getDescription());
            ad.setPrice(source.getPrice());
            ad.setPublishTime(source.getPublishTime());
            ad.setRooms(source.getAmountOfRooms());
            ad.setStreet(source.getStreet());
            ad.setTitle(source.getTitle());
            ad.setUrl(source.getUrl());
            ads.add(ad);
        }
        return ads;
    }
}
