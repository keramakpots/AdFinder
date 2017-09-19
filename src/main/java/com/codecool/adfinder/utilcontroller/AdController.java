package com.codecool.adfinder.utilcontroller;

import com.codecool.adfinder.data.Ad;
import com.codecool.adfinder.data.AdServices;
import com.codecool.adfinder.parser.AdsFactory;
import com.codecool.adfinder.parser.AdsUrlsFactory;
import com.codecool.adfinder.parser.olximplement.urlgetter.OlxAdsUrls;
import com.codecool.adfinder.parser.utils.StreetFinderPattern;
import com.codecool.adfinder.parser.utils.StreetFinderStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AdController {

    @Autowired
    AdServices adServices;

    @RequestMapping(value = "/startdb")
    public String startDb() throws IOException {
        AdsUrlsFactory adsUrlsFactory = new AdsUrlsFactory();
        StreetFinderStrategy streetFinderStrategy = new StreetFinderPattern();
        AdsFactory adsFactory = new AdsFactory();
        for (Ad ad :
            adsFactory.from(adsUrlsFactory.from(), streetFinderStrategy)) {
            adServices.add(ad);
        }
        return "done";
    }
}
