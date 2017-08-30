package com.codecool.adfinder.controller;

import com.codecool.adfinder.data.Ad;
import com.codecool.adfinder.data.AdServices;
import com.codecool.adfinder.parser.olx.converter.HtmlToAdConverter;
import com.codecool.adfinder.parser.olx.sourcegetter.HtmlDataGetter;
import com.codecool.adfinder.parser.olx.urlgetter.AdsUrlsGetter;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AdController {

    @Autowired
    AdServices adServices;

    @RequestMapping( value = "/startdb" )
    public String startDb() throws IOException {
        AdsUrlsGetter adsUrlsGetter = new AdsUrlsGetter();
        adsUrlsGetter.parseForUrls();
        List<HtmlDataGetter> htmlDataGetterList = new ArrayList<>();
        for (String url :
                adsUrlsGetter.getUrls()) {
            HtmlDataGetter htmlDataGetter = new HtmlDataGetter(url);
            htmlDataGetterList.add(htmlDataGetter);
        }
        HtmlToAdConverter htmlToAdConverter = new HtmlToAdConverter(htmlDataGetterList);
        for (Ad ad :
                htmlToAdConverter.getAdFromSource()) {
            adServices.add(ad);
        }
        return "done";
    }
}
