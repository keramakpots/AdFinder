package com.codecool.adfinder.data;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdServices {

    @Autowired
    AdRepository adRepository;

    public void add(Ad ad) {
        adRepository.save(ad);
    }

    public List<Ad> getAdsByMinPriceAndMaxPriceAndRooms(Integer minPrice, Integer maxPrice,
        Integer rooms) {
        return adRepository
            .getAdsByStreetNotNullAndPriceIsGreaterThanEqualAndPriceIsLessThanEqualAndRoomsEquals(
                minPrice, maxPrice, rooms);
    }
}
