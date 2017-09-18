package com.codecool.adfinder.parser.olximplement.sourceparser;

import com.codecool.adfinder.data.Ad;
import com.codecool.adfinder.parser.AdStrategy;
import com.codecool.adfinder.parser.utils.StreetFinderStrategy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OlxAdStrategy implements AdStrategy {
    private Ad.AdBuilder adBuilder;
    private Document source;
    private Map<String, String> properties;
    private StreetFinderStrategy streetFinderStrategy;

    // TODO: 18/09/2017 give Document html instead or url
    public OlxAdStrategy(String url, StreetFinderStrategy streetFinderStrategy) throws IOException {
        this.streetFinderStrategy = streetFinderStrategy;
        initBuild(url);
        adBuilder = Ad.AdBuilder.anAd();
    }

    public void execute() {
        this.amountOfRooms();
        this.description();
        this.Price();
        this.publishTime();
        this.title();
        this.url();
        this.street();
    }

    @Override
    public Ad getAd() {
        return adBuilder.build();
    }

    private void amountOfRooms() {
        String rooms = properties.get("Liczba pokoi");
        if (rooms == null) {
            adBuilder.rooms(null);
        }
        if (rooms.equals("Kawalerka")) {
            adBuilder.rooms(1);
        }
        adBuilder.rooms(Character.getNumericValue(rooms.charAt(0)));
    }

    private void url() {
        adBuilder.url(source.location());
    }

    private void street() {
        adBuilder.street(streetFinderStrategy.getStreet(source.getElementById("textContent").text()));
    }

    private void description() {
        adBuilder.description(source.getElementById("textContent").text());
    }
    // TODO: 16/08/2017 get proper time and date

    // hour: \d{2}:\d{2}
    // date: \d+\s\w+\s\d+
    private void publishTime() {
        adBuilder.publishTime(source.getElementsByClass("offer-titlebox__details").select("em").text());
    }

    private void title() {
        adBuilder.title(source.getElementsByTag("title").text());
    }

    private void Price() {
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

    private void buildSource(String url) throws IOException {
        source = Jsoup.connect(url).get();
    }

    private void initBuild(String url) throws IOException {
        buildSource(url);
        setProperties();
    }
}
