package com.codecool.adfinder.parser.olx.urlgetter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdsUrlsGetter {
    private static boolean isUrlsSet = false;
    private final String url = "https://www.olx.pl/nieruchomosci/mieszkania/wynajem/krakow/";
    private final String page = "?page=";
    private final Integer maxPage = 35;
    private Integer currentPageNumber;
    private List<Document> listOfHtmlPages;
    private Set<String> urls;

    public void parseForUrls() throws IOException {
        createListOfDocuments();
        getUrlsFromHtmlPages();
    }

    public String getUrl() throws IllegalAccessException {
        if(isUrlsSet) {
            return url;
        }
        throw new IllegalAccessException("Urls are not parsed");
    }

    private void getUrlsFromHtmlPages() {
        if (!isUrlsSet) {
            urls = new HashSet<>();
            for (Document sourceCode : listOfHtmlPages) {
                urls.addAll(normalizeUrls(removeNotOLXUrls(sourceCode.getElementsByClass("marginright5").eachAttr("href"))));
            }
            isUrlsSet = true;
        }
    }

    private List<String> normalizeUrls(List<String> listOfUrlsWithEnd) {
        for (int i = 0; i < listOfUrlsWithEnd.size(); i++) {
            if (listOfUrlsWithEnd.get(i).endsWith(";promoted")) {
                String correctUrl = listOfUrlsWithEnd.get(i).substring(0, listOfUrlsWithEnd.get(i).length() - 9);
                listOfUrlsWithEnd.set(i, correctUrl);
            }
        }
        return listOfUrlsWithEnd;
    }

    private List<String> removeNotOLXUrls(List<String> urls) {
        Pattern pattern = Pattern.compile("otodom");
        ListIterator<String> iter = urls.listIterator();
        while(iter.hasNext()){
            Matcher matcher = pattern.matcher(iter.next());
            if(matcher.find()){
                iter.remove();
            }
        }
        return urls;
    }


    private void createListOfDocuments() throws IOException {
        while (currentPageNumber < maxPage) {
            String currentUrl = url+page+ currentPageNumber;
            Document sourceHtml = Jsoup.connect(currentUrl).get();
            listOfHtmlPages.add(sourceHtml);
            currentPageNumber++;
        }
        currentPageNumber++;
    }
}
