package com.codecool.adfinder.parser;

import com.codecool.adfinder.data.Ad;

public interface AdStrategy {
    void execute();
    Ad getAd();
}
