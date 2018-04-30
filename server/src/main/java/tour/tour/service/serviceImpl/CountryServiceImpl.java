package tour.tour.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tour.tour.entity.Country;
import tour.tour.repository.CountryRepository;
import tour.tour.service.CountryService;

import java.util.List;

@Service("countryService")
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country change(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country findOne(Long id) {
        return countryRepository.findOne(id);
    }

    @Override
    public Country findByName(String name) {
        return countryRepository.findByName(name);
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAllById();
    }

    @Override
    public void delete(Long id) {
        countryRepository.delete(id);
    }

    @Override
    public void deleteByName(String name) {
        countryRepository.deleteByName(name);
    }


    @Override
    public void delete(Country country) {
        countryRepository.delete(country);
    }
}
