package tour.tour.service;

import tour.tour.entity.Client;
import tour.tour.entity.Country;

import java.util.List;

public interface CountryService {
    Country save(Country country);
    Country change(Country country);
    Country findOne(Long id);
    Country findByName(String name);
    List<Country> findAll();
    void delete(Long id);
    void deleteByName(String name);
    void delete(Country country);
}
