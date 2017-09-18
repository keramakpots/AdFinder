package com.codecool.adfinder.parser.olximplement.sourceparser;

import com.codecool.adfinder.data.Ad;
import com.codecool.adfinder.parser.sourceparser.AdFromHtmlBuilder;
import com.codecool.adfinder.parser.utils.StreetFinderStrategy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OlxAdFromHtmlBuilder implements AdFromHtmlBuilder {
    private Ad.AdBuilder adBuilder;
    private Document source;
    private Map<String, String> properties;
    private StreetFinderStrategy streetFinderStrategy;

    public OlxAdFromHtmlBuilder(String url, StreetFinderStrategy streetFinderStrategy) throws IOException {
        this.streetFinderStrategy = streetFinderStrategy;
        initBuild(url);
        adBuilder = Ad.AdBuilder.anAd();
    }

    @Override
    public void buildAmountOfRooms() {
        String rooms = properties.get("Liczba pokoi");
        if (rooms == null) {
            adBuilder.rooms(null);
        }
        if (rooms.equals("Kawalerka")) {
            adBuilder.rooms(1);
        }
        adBuilder.rooms(Character.getNumericValue(rooms.charAt(0)));
    }

    @Override
    public void buildUrl() {
        adBuilder.url(source.location());
    }

    public void buildStreet() {
        adBuilder.street(streetFinderStrategy.getStreet(source.getElementById("textContent").text()));
    }

    @Override
    public void buildDescription() {
        adBuilder.description(source.getElementById("textContent").text());
    }

    // TODO: 16/08/2017 get proper time and date
    // hour: \d{2}:\d{2}
    // date: \d+\s\w+\s\d+
    @Override
    public void buildPublishTime() {
        adBuilder.publishTime(source.getElementsByClass("offer-titlebox__details").select("em").text());
    }

    @Override
    public void buildTitle() {
        adBuilder.title(source.getElementsByTag("title").text());
    }

    @Override
    public void buildPrice() {
        String priceWithCurrency = source.getElementsByClass("price-label").text().replaceAll("\\D+", "");
        if (priceWithCurrency.length() == 0) {
            adBuilder.price(null);
        }
        adBuilder.price(Integer.parseInt(priceWithCurrency));
    }

    private void setProperties() {
        List<String> category = source.getElementsByClass("item").select("th").eachText();
        List<String> value = source.getElementsByClass("item").select("td").eachText();
        Map<String, String> properties = new HashMap<>();
        for (int i = 0; i < value.size(); i++) {
            properties.put(category.get(i), value.get(i));
        }
        this.properties = properties;
    }

    @Override
    public Ad getAd() {
        return adBuilder.build();
    }

    private void buildSource(String url) throws IOException {
        source = Jsoup.connect(url).get();
    }

    private void initBuild(String url) throws IOException {
        buildSource(url);
        setProperties();
    }
}
