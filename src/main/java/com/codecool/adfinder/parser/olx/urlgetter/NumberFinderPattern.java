package com.codecool.adfinder.parser.olx.urlgetter;

import java.util.regex.Pattern;

public class NumberFinderPattern {
    private Pattern pattern = Pattern.compile("\\d+");
    private static NumberFinderPattern ourInstance = new NumberFinderPattern();

    public static NumberFinderPattern getInstance() {
        return ourInstance;
    }

    public Pattern getPattern() {
        return pattern;
    }
}
