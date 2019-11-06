package pe.isil.isilcatalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.isilcatalog.model.City;
import pe.isil.isilcatalog.repository.city.JdbcCityRepository;

import java.util.List;

@Service
public class CityService implements BaseService<City, Long> {
    @Autowired
    private JdbcCityRepository repository;

    @Override
    public List<City> findAll() {
        try{
            return repository.findAll();
        }
        catch (Exception ex){
            return null;
        }
    }

    @Override
    public City findById(Long id) {
        try {
            return repository.findById(id);
        }
        catch (Exception ex){
            return null;
        }
    }

    @Override
    public void create(City city) {
        repository.create(city);
    }

    @Override
    public void update(City city) {
        repository.update(city);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    public List<City> listCitiesByCountry(Long id) {
        return repository.findAllCities(id);
    }
}
