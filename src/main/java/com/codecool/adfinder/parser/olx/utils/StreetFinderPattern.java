package com.codecool.adfinder.parser.olx.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StreetFinderPattern {
    private Pattern pattern;
    private final String filename = "streets.txt";

    private static StreetFinderPattern ourInstance = new StreetFinderPattern();

    public static StreetFinderPattern getInstance() {
        return ourInstance;
    }

    private StreetFinderPattern() {
        createPattern();
    }

    public Pattern getPattern() {
        return pattern;
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
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
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
}
