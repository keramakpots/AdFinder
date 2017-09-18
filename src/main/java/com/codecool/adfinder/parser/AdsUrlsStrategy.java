package com.codecool.adfinder.parser;

import java.io.IOException;
import java.util.Set;

public interface AdsUrlsStrategy {
    void execute() throws IOException;
    Set<String> getUrls();
}
