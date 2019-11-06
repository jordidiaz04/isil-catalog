package pe.isil.isilcatalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.isilcatalog.model.Country;
import pe.isil.isilcatalog.service.CountryService;

import java.util.List;

@Controller
public class CountryController {
    @Autowired
    private CountryService service;

    @GetMapping("/countries")
    public String getCountriesList(Model model) {
        List<Country> countries = service.findAll();
        model.addAttribute("countries", countries);
        return "country";
    }

    @GetMapping("/countries/add")
    public String addCountry(Model model) {
        model.addAttribute("country", new Country());
        return "country-add";
    }

    @PostMapping("/countries/save")
    public String saveCountry(Country country, Model model) {
        service.create(country);
        return getCountriesList(model);
    }

    @GetMapping("/countries/edit/{id}")
    public String getCountryForUpdate(@PathVariable Long id, Model model) {
        Country country = service.findById(id);
        model.addAttribute("country", country);
        return "country-edit";
    }

    @PostMapping("/countries/update/{id}")
    public String updateCountry(@PathVariable Long id, Country country,Model model) {
        country.setId(id);
        service.update(country);
        return getCountriesList(model);
    }

    @GetMapping("/countries/delete/{id}")
    public String deleteCountry(@PathVariable Long id, Model model) {
        service.delete(id);
        return getCountriesList(model);
    }
}
