package com.codecool.adfinder.data;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface AdRepository extends CrudRepository<Ad, Long> {

    List<Ad> getAdsByStreetNotNullAndPriceIsGreaterThanEqualAndPriceIsLessThanEqualAndRoomsEquals(
        Integer minPrice, Integer maxPrice, Integer rooms);
}
