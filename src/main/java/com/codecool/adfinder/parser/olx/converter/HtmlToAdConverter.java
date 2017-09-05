package com.codecool.adfinder.parser.olx.converter;

import com.codecool.adfinder.data.Ad;
import com.codecool.adfinder.parser.olx.sourcegetter.HtmlDataGetter;
import lombok.val;

import java.util.ArrayList;
import java.util.List;

public class HtmlToAdConverter {
    private List<HtmlDataGetter> htmlData;

    public HtmlToAdConverter(List<HtmlDataGetter> htmlData) {
        this.htmlData = htmlData;
    }

    public List<Ad> getAdFromSource() {
        List<Ad> ads = new ArrayList<>();
        for (HtmlDataGetter source : htmlData) {
            Ad ad = Ad.builder()
           .description(source.getDescription())
           .price(source.getPrice())
           .publishTime(source.getPublishTime())
           .rooms(source.getAmountOfRooms())
           .street(source.getStreet())
           .title(source.getTitle())
           .url(source.getUrl()).build();
            ads.add(ad);
        }
        return ads;
    }
}
