package tour.tour.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tour.tour.entity.Resort;
import tour.tour.repository.ResortRepository;
import tour.tour.service.ResortService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service("resortService")
public class ResortServiceImpl implements ResortService {

    @Autowired
    private ResortRepository resortRepository;

    @Override
    public Resort save(Resort resort) {
        return resortRepository.save(resort);
    }

    @Override
    public Resort change(Resort resort) {
        return resortRepository.save(resort);
    }

    @Override
    public Resort findOne(Long id) {
        return resortRepository.findOne(id);
    }

    @Override
    public Resort findByName(String name) {
        return resortRepository.findByName(name);
    }

    @Override
    public List<Resort> findAll() {
        return resortRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        resortRepository.delete(id);
    }

    @Override
    public void deleteByName(String name) {
        resortRepository.deleteByName(name);
    }

    @Override
    public void delete(Resort resort) {
        resortRepository.delete(resort);
    }

    public void saveImage(MultipartFile multipartFile) {

        String UPLOADED_FOLDER = "/home/oleg/IdeaProjects/tour/front-end/src/assets/img/";

        if (multipartFile.isEmpty()) {

        }
        try {
            // Get the file and save it somewhere
            byte[] bytes = multipartFile.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + multipartFile.getOriginalFilename());
            Path write = Files.write(path, bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}