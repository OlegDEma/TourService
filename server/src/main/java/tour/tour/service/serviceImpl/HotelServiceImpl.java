package tour.tour.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tour.tour.entity.Hotel;
import tour.tour.repository.HotelRepository;
import tour.tour.service.HotelService;

import java.util.List;

@Service("hotelService")
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel save(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel change(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel findOne(Long id) {
        return hotelRepository.findOne(id);
    }

    @Override
    public Hotel findByName(String name) {
        return hotelRepository.findByName(name);
    }

    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        hotelRepository.delete(id);
    }

    @Override
    public void deleteByName(String name) {
        hotelRepository.deleteByName(name);
    }

    @Override
    public void delete(Hotel hotel) {
        hotelRepository.delete(hotel);
    }
}
