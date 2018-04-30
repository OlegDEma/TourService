package tour.tour.service;

import org.springframework.web.multipart.MultipartFile;
import tour.tour.entity.Hotel;
import tour.tour.entity.Resort;

import java.util.List;

public interface ResortService {
    Resort save(Resort resort);
    Resort change(Resort resort);
    Resort findOne(Long id);
    Resort findByName(String name);
    List<Resort> findAll();
    void delete(Long id);
    void deleteByName(String name);
    void delete(Resort resort);
    void saveImage(MultipartFile multipartFile);
}
