package com.codecool.adfinder.parser.olximplement.converter;

import com.codecool.adfinder.data.Ad;
import com.codecool.adfinder.parser.olximplement.sourceparser.OlxAdFromHtmlBuilder;

import java.util.ArrayList;
import java.util.List;

public class HtmlToAdConverter {
    private List<OlxAdFromHtmlBuilder> htmlData;

    public HtmlToAdConverter(List<OlxAdFromHtmlBuilder> htmlData) {
        this.htmlData = htmlData;
    }

    public List<Ad> getAdFromSource() {
        List<Ad> ads = new ArrayList<>();
        for (OlxAdFromHtmlBuilder builder : htmlData) {
            builder.buildAmountOfRooms();
            builder.buildDescription();
            builder.buildPrice();
            builder.buildPublishTime();
            builder.buildTitle();
            builder.buildUrl();
            builder.buildStreet();
            ads.add(builder.getAd());
        }
        return ads;
    }
}
