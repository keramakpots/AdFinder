package com.codecool.adfinder.parser;

import com.codecool.adfinder.parser.olximplement.urlgetter.OlxAdsUrls;

import java.io.IOException;
import java.util.Set;

public class AdsUrlsFactory {

    public Set<String> from() throws IOException {
        AdsUrlsStrategy adsUrlsStrategy = new OlxAdsUrls();
        adsUrlsStrategy.execute();
        return adsUrlsStrategy.getUrls();
    }
}
