package com.codecool.adfinder.parser;

import com.codecool.adfinder.data.Ad;
import com.codecool.adfinder.parser.olximplement.sourceparser.OlxAdStrategy;
import com.codecool.adfinder.parser.utils.StreetFinderStrategy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AdsFactory {

    public List<Ad> from(Set<String> urls, StreetFinderStrategy streetFinderStrategy) throws IOException {
        List<Ad> ads = new ArrayList<>();
        for (String url : urls) {
            AdStrategy adStrategy = new OlxAdStrategy(url, streetFinderStrategy);
            adStrategy.execute();
            ads.add(adStrategy.getAd());
        }
        return ads;
    }
}
