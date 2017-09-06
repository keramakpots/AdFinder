package com.codecool.adfinder.parser.olx.sourcegetter;

import com.codecool.adfinder.parser.olx.utils.StreetFinderPattern;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HtmlDataGetter {

    private String url;
    private String street;
    private String description;
    private String publishTime;
    private Integer price;
    private Integer amountOfRooms;
    private Document source;
    private String title;
    private Map<String, String> properties;

    public HtmlDataGetter(String url) throws IOException, NullPointerException {
        setAdParameters(url);
    }

    public String getUrl() {
        return url;
    }

    public String getStreet() {
        return street;
    }

    public String getDescription() {
        return description;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getAmountOfRooms() {
        return amountOfRooms;
    }

    public String getTitle() {
        return title;
    }

    private void setAdParameters(String url) throws IOException, NullPointerException {
        this.url = url;
        source = getSourceFromUrl(this.url);
        description = getDescriptionFromSource();
        street = getStreetFromDescription();
        properties = setProperties();
        publishTime = getPublishTimeFromSource();
        price = getPriceFromSource();
        title = getTitleFromSource();
        amountOfRooms = getRoomsFromSource();
    }

    private Integer getLengthOfStreet() {
        if (street == null) {
            return null;
        }
        return street.length();
    }

    private Integer getRoomsFromSource() {
        String rooms = properties.get("Liczba pokoi");
        if (rooms == null) {
            return null;
        }
        if (rooms.equals("Kawalerka")) {
            return 1;
        }
        return Character.getNumericValue(rooms.charAt(0));
    }

    private String getStreetFromDescription() {
        Matcher matcher = StreetFinderPattern.getInstance().getPattern().matcher(description);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    private String getTitleFromSource() {
        return source.getElementsByTag("title").text();
    }

    private Integer getPriceFromSource() {
        String priceWithCurrency = source.getElementsByClass("price-label").text()
            .replaceAll("\\D+", "");
        ;
        if (priceWithCurrency.length() == 0) {
            return null;
        }
        return Integer.parseInt(priceWithCurrency);
    }

    // TODO: 16/08/2017 get proper time and date
    // hour: \d{2}:\d{2}
    // date: \d+\s\w+\s\d+
    private String getPublishTimeFromSource() {
        return source.getElementsByClass("offer-titlebox__details").select("em").text();
    }

    private Map<String, String> setProperties() {
        List<String> category = source.getElementsByClass("item").select("th").eachText();
        List<String> value = source.getElementsByClass("item").select("td").eachText();
        Map<String, String> properties = new HashMap<>();
        for (int i = 0; i < value.size(); i++) {
            properties.put(category.get(i), value.get(i));
        }
        return properties;
    }

    private String getDescriptionFromSource() throws NullPointerException {
        return source.getElementById("textContent").text();
    }

    private Document getSourceFromUrl(String url) throws IOException {
        return Jsoup.connect(url).get();
    }

}
