package com.codecool.adfinder.parser.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StreetFinderPattern implements StreetFinderStrategy {
    private Pattern pattern;
    private final String filename = "/home/marek/kodowanie/test/Test finder/AdFinder/src/main/resources/streets.txt";

    public StreetFinderPattern() {
        createPattern();
    }

    private void createPattern() {
        List<String> streets = null;
        try {
            streets = readFile(filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        for (String street : streets) {
            stringBuilder.append(street.substring(1));
            stringBuilder.append("|");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append(")");
        stringBuilder.append("(\\s+(\\d+\\w*))?");
        // TODO: 16/08/2017 get rid of insensitive case and create pattern with all possible combi. remove eg"gazowa"
        // TODO: 17/08/2017 Pattern.CASE_INSENSITIVE ???
        pattern = Pattern.compile(stringBuilder.toString());
    }

    private List<String> readFile(String filename) throws Exception {
        String line = null;
        List<String> records = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        while ((line = bufferedReader.readLine()) != null) {
            records.add(line);
        }
        bufferedReader.close();
        return records;
    }

    @Override
    public String getStreet(String description) {
        Matcher matcher = pattern.matcher(description);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }
}
