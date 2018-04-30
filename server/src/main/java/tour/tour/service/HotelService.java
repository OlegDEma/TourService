package tour.tour.service;

import tour.tour.entity.Country;
import tour.tour.entity.Hotel;

import java.util.List;

public interface HotelService {
    Hotel save(Hotel hotel);
    Hotel change(Hotel hotel);
    Hotel findOne(Long id);
    Hotel findByName(String name);
    List<Hotel> findAll();
    void delete(Long id);
    void deleteByName(String name);
    void delete(Hotel hotel);
}
