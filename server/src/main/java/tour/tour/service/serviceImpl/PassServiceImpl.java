package tour.tour.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tour.tour.entity.Pass;
import tour.tour.repository.PassRepository;
import tour.tour.service.PassService;

import java.util.List;

@Service("passService")
public class PassServiceImpl implements PassService {

    @Autowired
    private PassRepository passRepository;

    @Override
    public Pass save(Pass pass) {
        return passRepository.save(pass);
    }

    @Override
    public Pass change(Pass pass) {
        return passRepository.save(pass);
    }

    @Override
    public Pass findOne(Long id) {
        return passRepository.findOne(id);
    }

    @Override
    public List<Pass> findAll() {
        return passRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        passRepository.delete(id);
    }

    @Override
    public void delete(Pass pass) {
        passRepository.delete(pass);
    }
}
