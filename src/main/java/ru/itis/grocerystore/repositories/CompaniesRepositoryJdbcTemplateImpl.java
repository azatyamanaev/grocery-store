package ru.itis.grocerystore.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.itis.grocerystore.models.*;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Repository
public class CompaniesRepositoryJdbcTemplateImpl implements CompaniesRepository {

    //language=SQL
    private final String SQL_INSERT = "insert into companies" +
            "(login, password, name, linktosite, about, number, email, additionalinformation, role, state) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    //language=SQL
    private final String SQL_UPDATE = "update companies \n" +
            "set login = ?, password = ?, name = ?, linktosite = ?, about = ?, \n" +
            "number = ?, email = ?, additionalinformation = ?, role = ?, state = ? \n" +
            "where id = ?";
    //language=SQL
    private final String SQL_SELECT_ALL = "select * from companies";
    //language=SQL
    private final String SQL_SELECT_BY_ID = "select * from companies where id = ?";
    //language=SQL
    private final String SQL_SELECT_BY_LOGIN = "select * from companies where login = ?";
    //language=SQL
    private final String SQL_DELETE_BY_ID = "delete from companies where id = ?";
    //language=SQL
    private final String SQL_GET_LOGO = "select logo.id, path, size, type from logo join companies c on logo.company_id = c.id where c.id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Company> companyRowMapper = (row, rowNumber) ->
            Company.builder()
                    .id(row.getLong("id"))
                    .login(row.getString("login"))
                    .password(row.getString("password"))
                    .name(row.getString("name"))
                    .linkToSite(row.getString("linktosite"))
                    .about(row.getString("about"))
                    .number(row.getString("number"))
                    .email(row.getString("email"))
                    .additionalInformation(row.getString("additionalinformation"))
                    .role(Role.valueOf(row.getString("role")))
                    .state(State.valueOf(row.getString("state")))
                    .build();

    private RowMapper<Logo> logoRowMapper = (row, rowNumber) ->
            Logo.builder()
                    .id(row.getLong("id"))
                    .type(row.getString("type"))
                    .path(row.getString("path"))
                    .size(row.getLong("size"))
                    .build();

    @Override
    public Optional<Logo> getLogo(Long id) {
        try {
            Logo logo = jdbcTemplate.queryForObject(SQL_GET_LOGO, new Object[]{id}, logoRowMapper);
            logo.loadFile();
            return Optional.ofNullable(logo);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public void save(Company model) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(dataSource -> {
            PreparedStatement statement = dataSource.prepareStatement(SQL_INSERT);
            statement.setString(1, model.getLogin());
            statement.setString(2, model.getPassword());
            statement.setString(3, model.getName());
            statement.setString(4, model.getLinkToSite());
            statement.setString(5, model.getAbout());
            statement.setString(6, model.getNumber());
            statement.setString(7, model.getEmail());
            statement.setString(8, model.getAdditionalInformation());
            statement.setString(9, String.valueOf(Role.TEACHER));
            statement.setString(10, String.valueOf(State.NOT_CONFIRMED));
            return statement;
        }, keyHolder);
        model.setId((Long) keyHolder.getKey());
    }

    @Override
    public void update(Company model) {
        jdbcTemplate.update(dataSource -> {
            PreparedStatement statement = dataSource.prepareStatement(SQL_UPDATE);
            statement.setString(1, model.getLogin());
            statement.setString(2, model.getPassword());
            statement.setString(3, model.getName());
            statement.setString(4, model.getLinkToSite());
            statement.setString(5, model.getAbout());
            statement.setString(6, model.getNumber());
            statement.setString(7, model.getEmail());
            statement.setString(8, model.getAdditionalInformation());
            statement.setString(9, String.valueOf(Role.TEACHER));
            statement.setString(10, String.valueOf(State.NOT_CONFIRMED));
            statement.setLong(11, model.getId());
            return statement;
        });
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(dataSource -> {
            PreparedStatement statement = dataSource.prepareStatement(SQL_DELETE_BY_ID);
            statement.setLong(1, id);
            return statement;
        });
    }

    @Override
    public Optional<Company> find(Long id) {
        try {
            Company company = jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, new Object[]{id}, companyRowMapper);
            Optional<Logo> optionalLogo = getLogo(id);
            optionalLogo.ifPresent(company::setLogo);
            return Optional.ofNullable(company);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Company> findByLogin(String login) {
        try {
            Company company = jdbcTemplate.queryForObject(SQL_SELECT_BY_LOGIN, new Object[]{login}, companyRowMapper);
            return Optional.ofNullable(company);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Company> findAll() {
        List<Company> companies = jdbcTemplate.query(SQL_SELECT_ALL, companyRowMapper);
        for (Company company : companies) {
            Optional<Logo> optionalTeacherImage = getLogo(company.getId());
            optionalTeacherImage.ifPresent(company::setLogo);
        }
        return companies;
    }
}
