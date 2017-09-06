package com.codecool.adfinder.utilcontroller;

import com.codecool.adfinder.data.Ad;
import com.codecool.adfinder.data.AdServices;
import com.codecool.adfinder.parser.olx.converter.HtmlToAdConverter;
import com.codecool.adfinder.parser.olx.sourcegetter.HtmlDataGetter;
import com.codecool.adfinder.parser.olx.urlgetter.AdsUrlsGetter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdController {

    @Autowired
    AdServices adServices;

    @RequestMapping(value = "/startdb")
    public String startDb() throws IOException {
        AdsUrlsGetter adsUrlsGetter = new AdsUrlsGetter();
        adsUrlsGetter.parseForUrls();
        List<HtmlDataGetter> htmlDataGetterList = new ArrayList<>();
        for (String url :
            adsUrlsGetter.getUrls()) {
            try {
                HtmlDataGetter htmlDataGetter = new HtmlDataGetter(url);
                htmlDataGetterList.add(htmlDataGetter);
            } catch (NullPointerException e) {
                System.out.println("Ad doesn't exist ");
            }
        }
        HtmlToAdConverter htmlToAdConverter = new HtmlToAdConverter(htmlDataGetterList);
        for (Ad ad :
            htmlToAdConverter.getAdFromSource()) {
            adServices.add(ad);
        }
        return "done";
    }
}
