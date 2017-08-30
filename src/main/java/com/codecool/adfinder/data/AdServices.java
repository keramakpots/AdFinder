package com.codecool.adfinder.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdServices {
    @Autowired
    AdRepository adRepository;

    public void add(Ad ad) {
        adRepository.save(ad);
    }
    public List<Ad> getAdByParameters(Integer minPrice, Integer maxPrice, Integer rooms) {
        return adRepository.getAdsByStreetNotNull();
    }
}
