package pe.isil.isilcatalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.isilcatalog.model.City;
import pe.isil.isilcatalog.model.Country;
import pe.isil.isilcatalog.repository.country.JdbcCountryRepository;

import java.util.List;

@Service
public class CountryService implements BaseService<Country, Long> {
    @Autowired
    private JdbcCountryRepository repository;

    @Override
    public List<Country> findAll() {
        try {
            return repository.findAll();
        }
        catch (Exception ex){
            return  null;
        }
    }

    @Override
    public Country findById(Long id) {
        try {
            return repository.findById(id);
        }
        catch (Exception ex){
            return  null;
        }
    }

    @Override
    public void create(Country country) {
        repository.create(country);
    }

    @Override
    public void update(Country country) {
        repository.update(country);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}
