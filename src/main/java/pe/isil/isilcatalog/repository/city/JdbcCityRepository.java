package pe.isil.isilcatalog.repository.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.isil.isilcatalog.model.City;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcCityRepository implements CityRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<City> findAll() {
        final String sql = "select c.*, ct.name as pais from City c inner join Country ct on c.idCountry = ct.id";
        return jdbcTemplate.query(sql, JdbcCityRepository::CityRowMapper);
    }

    @Override
    public City findById(Long id) {
        final String sql = "select c.*, ct.name as pais from City c inner join Country ct on c.idCountry = ct.id where c.id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, JdbcCityRepository::CityRowMapper);
    }

    @Override
    public void create(City city) {
        final String sql = "insert into City (name, idCountry) values (?,?)";
        jdbcTemplate.update(sql, city.getName(), city.getIdCountry());
    }

    @Override
    public void update(City city) {
        final String sql = "update City set name = ?, idCountry = ? where id = ?";
        jdbcTemplate.update(sql, city.getName(), city.getIdCountry(), city.getId());
    }

    @Override
    public void delete(Long id) {
        final String sql = "delete from City where id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<City> findAllCities(Long idCountry){
        final String sql = "select c.*, ct.name as pais from City c inner join Country ct on c.idCountry = ct.id where idCountry = ?";
        return jdbcTemplate.query(sql, new Object[]{idCountry}, JdbcCityRepository::CityRowMapper);
    }

    private static City CityRowMapper(ResultSet resultSet, int i) throws SQLException {
        Long rsId = resultSet.getLong("id");
        String rsName = resultSet.getString("name");
        Long rsIdCountry = resultSet.getLong("idCountry");
        String rsPais = resultSet.getString("pais");
        return new City(rsId, rsName, rsIdCountry, rsPais);
    }
}
