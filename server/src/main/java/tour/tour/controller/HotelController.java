package tour.tour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tour.tour.entity.Hotel;
import tour.tour.service.HotelService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HotelController {

    @Autowired
    private HotelService hotelService;


    @PostMapping("/saveHotel")
    public Hotel saveHotel(@RequestBody Hotel hotel) {
        return hotelService.save(hotel);
    }


    @GetMapping("/deleteHotel/{id}")
    public ResponseEntity deleteHotel(@PathVariable("id") Long id) {
        hotelService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping("/getHotel")
    public List<Hotel> getHotel() {
        return hotelService.findAll();
    }

    @GetMapping("/getHotel/{id}")
    public Hotel getHotelByID(@PathVariable("id") Long id) {
        return hotelService.findOne(id);
    }

}
