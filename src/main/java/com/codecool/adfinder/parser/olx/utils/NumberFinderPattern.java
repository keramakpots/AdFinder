package com.codecool.adfinder.parser.olx.utils;

import java.util.regex.Pattern;

public class NumberFinderPattern {

    private final Pattern pattern = Pattern.compile("\\d+");
    private static final NumberFinderPattern ourInstance = new NumberFinderPattern();

    public static NumberFinderPattern getInstance() {
        return ourInstance;
    }

    public Pattern getPattern() {
        return pattern;
    }
}
