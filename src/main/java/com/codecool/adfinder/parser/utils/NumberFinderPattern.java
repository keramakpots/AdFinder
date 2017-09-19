package com.codecool.adfinder.parser.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberFinderPattern implements NumberFinderStrategy {

    private Pattern pattern;

    public NumberFinderPattern() {
        createPattern();
    }

    private void createPattern() {
        pattern = Pattern.compile("\\d+");
    }

    @Override
    public Integer getNumber(String source) {
        Matcher matcher = pattern.matcher(source);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        }
        return null;
    }
}
