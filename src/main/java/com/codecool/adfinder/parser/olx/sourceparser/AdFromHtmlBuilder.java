package com.codecool.adfinder.parser.olx.sourceparser;

import com.codecool.adfinder.data.Ad;

public interface AdFromHtmlBuilder {
    void buildUrl();
    void buildStreet();
    void buildDescription();
    void buildPublishTime();
    void buildPrice();
    void buildAmountOfRooms();
    void buildTitle();
    Ad getAd();
}
