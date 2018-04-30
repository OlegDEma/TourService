package tour.tour.service;

import tour.tour.entity.Hotel;
import tour.tour.entity.Pass;

import java.util.List;

public interface PassService {
    Pass save(Pass pass);
    Pass change(Pass pass);
    Pass findOne(Long id);
    List<Pass> findAll();
    void delete(Long id);
    void delete(Pass pass);
}
