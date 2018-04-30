package tour.tour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tour.tour.entity.Resort;
import tour.tour.service.ResortService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ResortController {

    @Autowired
    private ResortService resortService;

    @PostMapping("/saveResort")
    public Resort saveResort(@RequestBody Resort resort) {
        return resortService.save(resort);
    }


    @GetMapping("/deleteResort/{id}")
    public ResponseEntity deleteResort(@PathVariable("id") Long id) {
        resortService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping("/getResort")
    public List<Resort> getResort() {
        return resortService.findAll();
    }

    @PostMapping("/saveImageForProduct")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {

        resortService.saveImage(file);
        return "ok";
    }

}
