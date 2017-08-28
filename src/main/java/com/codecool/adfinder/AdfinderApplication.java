package com.codecool.adfinder;

import com.codecool.adfinder.parser.olx.converter.HtmlToAdConverter;
import com.codecool.adfinder.parser.olx.sourcegetter.HtmlDataGetter;
import com.codecool.adfinder.parser.olx.urlgetter.AdsUrlsGetter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AdfinderApplication {

	public static void main(String[] args) throws IOException, IllegalAccessException {
		SpringApplication.run(AdfinderApplication.class, args);
	}
}
