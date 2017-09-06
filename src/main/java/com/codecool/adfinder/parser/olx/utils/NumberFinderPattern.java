package com.codecool.adfinder.parser.olx.utils;

import java.util.regex.Pattern;

public class NumberFinderPattern {

    private static NumberFinderPattern ourInstance = new NumberFinderPattern();
    private Pattern pattern = Pattern.compile("\\d+");

    public static NumberFinderPattern getInstance() {
        return ourInstance;
    }

    public Pattern getPattern() {
        return pattern;
    }
}
