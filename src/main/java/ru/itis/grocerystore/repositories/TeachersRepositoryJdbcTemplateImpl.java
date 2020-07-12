package ru.itis.grocerystore.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.itis.grocerystore.models.Role;
import ru.itis.grocerystore.models.State;
import ru.itis.grocerystore.models.Teacher;
import ru.itis.grocerystore.models.TeacherImage;

import javax.swing.text.html.Option;
import java.sql.PreparedStatement;
import java.sql.SQLInput;
import java.util.List;
import java.util.Optional;

@Repository
public class TeachersRepositoryJdbcTemplateImpl implements TeachersRepository {

    //language=SQL
    private final String SQL_INSERT = "insert into teachers" +
            "(login, password, email, name, lastname, patronymic, position, about, role, state) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    //language=SQL
    private final String SQL_UPDATE = "update teachers \n" +
            "set login = ?, password = ?, email = ?, name = ?, lastname = ?, \n" +
            "patronymic = ?, position = ?, about = ?, role = ?, state = ? \n" +
            "where id = ?";
    //language=SQL
    private final String SQL_SELECT_ALL = "select * from teachers";
    //language=SQL
    private final String SQL_SELECT_BY_ID = "select * from teachers where id = ?";
    //language=SQL
    private final String SQL_DELETE_BY_ID = "delete from teachers where id = ?";
    //language=SQL
    private final String SQL_GET_IMAGE = "select teacherimage.id, path, size, type from teacherimage join teachers t on teacherimage.teacher_id = t.id where t.id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Teacher> teacherRowMapper = (row, rowNumber) ->
            Teacher.builder()
                    .id(row.getLong("id"))
                    .login(row.getString("login"))
                    .password(row.getString("password"))
                    .email(row.getString("email"))
                    .name(row.getString("name"))
                    .lastName(row.getString("lastname"))
                    .patronymic(row.getString("patronymic"))
                    .position(row.getString("position"))
                    .about(row.getString("about"))
                    .role(Role.valueOf(row.getString("role")))
                    .state(State.valueOf(row.getString("state")))
                    .build();

    private RowMapper<TeacherImage> teacherImageRowMapper = (row, rowNumber) ->
            TeacherImage.builder()
                    .id(row.getLong("id"))
                    .type(row.getString("type"))
                    .path(row.getString("path"))
                    .size(row.getLong("size"))
                    .build();

    @Override
    public void save(Teacher model) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(dataSource -> {
            PreparedStatement statement = dataSource.prepareStatement(SQL_INSERT);
            statement.setString(1, model.getLogin());
            statement.setString(2, model.getPassword());
            statement.setString(3, model.getEmail());
            statement.setString(4, model.getName());
            statement.setString(5, model.getLastName());
            statement.setString(6, model.getPatronymic());
            statement.setString(7, model.getPosition());
            statement.setString(8, model.getAbout());
            statement.setString(9, String.valueOf(Role.TEACHER));
            statement.setString(10, String.valueOf(State.NOT_CONFIRMED));
            return statement;
        }, keyHolder);
        model.setId((Long) keyHolder.getKey());
    }

    @Override
    public void update(Teacher model) {
        jdbcTemplate.update(dataSource -> {
            PreparedStatement statement = dataSource.prepareStatement(SQL_UPDATE);
            statement.setString(1, model.getLogin());
            statement.setString(2, model.getPassword());
            statement.setString(3, model.getEmail());
            statement.setString(4, model.getName());
            statement.setString(5, model.getLastName());
            statement.setString(6, model.getPatronymic());
            statement.setString(7, model.getPosition());
            statement.setString(8, model.getAbout());
            statement.setString(9, String.valueOf(model.getRole()));
            statement.setString(10, String.valueOf(model.getState()));
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
    public Optional<Teacher> find(Long id) {
        try {
            Teacher teacher = jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, new Object[]{id}, teacherRowMapper);
            Optional<TeacherImage> optionalTeacherImage = getImage(id);
            optionalTeacherImage.ifPresent(teacher::setImage);
            return Optional.ofNullable(teacher);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Teacher> findAll() {
        List<Teacher> teachers = jdbcTemplate.query(SQL_SELECT_ALL, teacherRowMapper);
        for (Teacher teacher : teachers) {
            Optional<TeacherImage> optionalTeacherImage = getImage(teacher.getId());
            optionalTeacherImage.ifPresent(teacher::setImage);
        }
        return teachers;
    }

    @Override
    public Optional<TeacherImage> getImage(Long id) {
        try {
            TeacherImage image = jdbcTemplate.queryForObject(SQL_GET_IMAGE, new Object[]{id}, teacherImageRowMapper);
            image.loadFile();
            return Optional.ofNullable(image);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}
