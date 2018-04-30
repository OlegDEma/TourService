package tour.tour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tour.tour.entity.Pass;
import tour.tour.service.PassService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PassController {

    @Autowired
    private PassService passService;

    @PostMapping("/savePass")
    public Pass savePass(@RequestBody Pass pass) {
        return passService.save(pass);
    }


    @GetMapping("/deletePass/{id}")
    public ResponseEntity deletePass(@PathVariable("id") Long id) {
        passService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping("/getPass")
    public List<Pass> getPass() {
        return passService.findAll();
    }


}
