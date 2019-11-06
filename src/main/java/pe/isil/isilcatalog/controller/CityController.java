package pe.isil.isilcatalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.isilcatalog.model.City;
import pe.isil.isilcatalog.model.Country;
import pe.isil.isilcatalog.service.CityService;
import pe.isil.isilcatalog.service.CountryService;

import java.util.List;

@Controller
public class CityController {
    @Autowired
    private CityService service;
    @Autowired
    private CountryService serviceCountry;

    @GetMapping("/cities")
    public String getCitiesList(Model model) {
        List<City> cities = service.findAll();
        model.addAttribute("cities", cities);
        return "city";
    }

    @GetMapping("/cities/add")
    public String addCity(Model model) {
        model.addAttribute("city", new City());
        List<Country> countries = serviceCountry.findAll();
        model.addAttribute("countries", countries);
        return "city-add";
    }

    @PostMapping("/cities/save")
    public String saveCity(City city, Model model) {
        service.create(city);
        return getCitiesList(model);
    }

    @GetMapping("/cities/edit/{id}")
    public String getCityForUpdate(@PathVariable Long id, Model model) {
        City city = service.findById(id);
        model.addAttribute("city", city);
        List<Country> countries = serviceCountry.findAll();
        model.addAttribute("countries", countries);
        return "city-edit";
    }

    @PostMapping("/cities/update/{id}")
    public String updateCity(@PathVariable Long id, City city,Model model) {
        city.setId(id);
        service.update(city);
        return getCitiesList(model);
    }

    @GetMapping("/cities/delete/{id}")
    public String deleteCity(@PathVariable Long id, Model model) {
        service.delete(id);
        return getCitiesList(model);
    }

    @GetMapping("/countries/cities/{id}")
    public String getCitiesByCountry(@PathVariable Long id, Model model) {
        List<City> cities = service.listCitiesByCountry(id);
        model.addAttribute("cities", cities);
        return "country-cities";
    }
}
