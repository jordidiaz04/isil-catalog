package pe.isil.isilcatalog.repository.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.isil.isilcatalog.model.Country;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcCountryRepository implements CountryRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Country> findAll() {
        final String sql = "select * from Country";
        return jdbcTemplate.query(sql, JdbcCountryRepository::CountryRowMapper);
    }

    @Override
    public Country findById(Long id) {
        final String sql = "select * from Country where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, JdbcCountryRepository::CountryRowMapper);
    }

    @Override
    public void create(Country country) {
        final String sql = "insert into Country (name) values (?)";
        jdbcTemplate.update(sql, country.getName());
    }

    @Override
    public void update(Country country) {
        final String sql = "update Country set name = ? where id = ?";
        jdbcTemplate.update(sql, country.getName(), country.getId());
    }

    @Override
    public void delete(Long id) {
        final String sql = "delete from Country where id = ?";
        jdbcTemplate.update(sql, id);
    }

    private static Country CountryRowMapper(ResultSet resultSet, int i) throws SQLException {
        Long rsId = resultSet.getLong("id");
        String rsName = resultSet.getString("name");
        return new Country(rsId, rsName);
    }
}
