package com.codecool.adfinder.data;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdRepository extends CrudRepository<Ad, Long> {
    List<Ad> getAdsByStreetNotNull();
}
