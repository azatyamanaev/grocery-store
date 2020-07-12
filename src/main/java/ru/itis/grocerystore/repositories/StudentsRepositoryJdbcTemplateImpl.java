package ru.itis.grocerystore.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.itis.grocerystore.models.*;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentsRepositoryJdbcTemplateImpl implements StudentsRepository {

    //language=SQL
    private final String SQL_INSERT = "insert into students" +
            "(login, password, email, name, lastname, patronymic, birthdate, educationallevel, university, faculty, " +
            "specialization, educationendyear, city, citizenship, gender, about, linktogit, workschedule, move, worksearching, role, state) " +
            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    //language=SQL
    private final String SQL_UPDATE = "update students \n" +
            "set login = ?, password = ?, email = ?, name = ?, lastname = ?, \n" +
            "patronymic = ?, birthdate = ?, educationallevel = ?, university = ?, faculty = ?, \n" +
            "specialization = ?, educationendyear = ?, city = ?, citizenship = ?, gender = ?, \n" +
            "about = ?, linktogit = ?, workschedule = ?, move = ?, worksearching = ?, \n" +
            "role = ?, state = ? \n" +
            "where id = ?";
    //language=SQL
    private final String SQL_SELECT_ALL = "select * from students";
    //language=SQL
    private final String SQL_SELECT_BY_ID = "select * from students where id = ?";
    //language=SQL
    private final String SQL_SELECT_BY_LOGIN = "select * from students where login = ?";
    //language=SQL
    private final String SQL_DELETE_BY_ID = "delete from students where id = ?";
    //language=SQL
    private final String SQL_GET_IMAGE = "select studentimage.id, path, size, type from studentimage join students s on studentimage.student_id = s.id where s.id = ?";
    //language=SQL
    private final String SQL_SELECT_SKILLS = "select skill.id, skill from skill join students s on skill.student_id = s.id where s.id = ?";
    //language=SQL
    private final String SQL_SELECT_LANGUAGES = "select language.id, language from language join students s on language.student_id = s.id where s.id = ?";
    //language=SQL
    private final String SQL_SELECT_WORK_EXPERIENCE = "select workexperience.id, duties, enddate, organization, position, startdate from workexperience join students s on workexperience.student_id = s.id where s.id = ?";
    //language=SQL
    private final String SQL_SELECT_ACHIEVEMENTS = "select achievement.id, path, size, type from achievement join students s on achievement.student_id = s.id where s.id = ?";
    //language=SQL
    private final String SQL_SELECT_RECOMMENDATION_LETTERS = "select recommendationletter.id, author, text from recommendationletter join students s on recommendationletter.student_id = s.id where s.id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Student> studentRowMapper = (row, rowNumber) ->
            Student.builder()
                    .id(row.getLong("id"))
                    .login(row.getString("login"))
                    .password(row.getString("password"))
                    .email(row.getString("email"))
                    .name(row.getString("name"))
                    .lastName(row.getString("lastname"))
                    .patronymic(row.getString("patronymic"))
                    .birthDate(row.getDate("birthdate"))
                    .educationalLevel(row.getString("educationallevel"))
                    .university(row.getString("university"))
                    .faculty(row.getString("faculty"))
                    .specialization(row.getString("specialization"))
                    .educationEndYear(row.getString("educationendyear"))
                    .city(row.getString("city"))
                    .citizenship(row.getString("citizenship"))
                    .gender(row.getString("gender"))
                    .about(row.getString("about"))
                    .linkToGit(row.getString("linktogit"))
                    .workSchedule(row.getString("workschedule"))
                    .move(row.getString("move"))
                    .workSearching(row.getBoolean("worksearching"))
                    .role(Role.valueOf(row.getString("role")))
                    .state(State.valueOf(row.getString("state")))
                    .build();

    private RowMapper<StudentImage> studentImageRowMapper = (row, rowNumber) ->
            StudentImage.builder()
                    .id(row.getLong("id"))
                    .type(row.getString("type"))
                    .path(row.getString("path"))
                    .size(row.getLong("size"))
                    .build();

    private RowMapper<Skill> skillRowMapper = (row, rowNumber) ->
            Skill.builder()
                    .id(row.getLong("id"))
                    .skill(row.getString("skill"))
                    .build();

    private RowMapper<Language> languageRowMapper = (row, rowNumber) ->
            Language.builder()
                    .id(row.getLong("id"))
                    .language(row.getString("language"))
                    .build();

    private RowMapper<WorkExperience> workExperienceRowMapper = (row, rowNumber) ->
            WorkExperience.builder()
                    .id(row.getLong("id"))
                    .startDate(row.getDate("startdate"))
                    .endDate(row.getDate("enddate"))
                    .organization(row.getString("organization"))
                    .position(row.getString("position"))
                    .duties(row.getString("duties"))
                    .build();

    private RowMapper<Achievement> achievementRowMapper = (row, rowNumber) ->
            Achievement.builder()
                    .id(row.getLong("id"))
                    .type(row.getString("type"))
                    .path(row.getString("path"))
                    .size(row.getLong("size"))
                    .build();

    private RowMapper<RecommendationLetter> recommendationLetterRowMapper = (row, rowNumber) ->
            RecommendationLetter.builder()
                    .id(row.getLong("id"))
                    .author(row.getString("author"))
                    .text(row.getString("text"))
                    .build();


    @Override
    public Optional<Student> findOneByLogin(String login) {
        try {
            Student student = jdbcTemplate.queryForObject(SQL_SELECT_BY_LOGIN, new Object[]{login}, studentRowMapper);
            Optional<StudentImage> optionalStudentImage = getImage(student.getId());
            optionalStudentImage.ifPresent(student::setImage);
            setAttributes(student);
            return Optional.ofNullable(student);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }


    @Override
    public List<Skill> getSkills(Long id) {
        return jdbcTemplate.query(SQL_SELECT_SKILLS, new Object[]{id}, skillRowMapper);
    }

    @Override
    public List<Language> getLanguages(Long id) {
        return jdbcTemplate.query(SQL_SELECT_LANGUAGES, new Object[]{id}, languageRowMapper);
    }

    @Override
    public Optional<StudentImage> getImage(Long id) {
        try {
            StudentImage image = jdbcTemplate.queryForObject(SQL_GET_IMAGE, new Object[]{id}, studentImageRowMapper);
            image.loadFile();
            return Optional.ofNullable(image);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<WorkExperience> getWorkExperience(Long id) {
        return jdbcTemplate.query(SQL_SELECT_WORK_EXPERIENCE, new Object[]{id}, workExperienceRowMapper);
    }

    @Override
    public List<Achievement> getAchievements(Long id) {
        List<Achievement> achievements = jdbcTemplate.query(SQL_SELECT_ACHIEVEMENTS, new Object[]{id}, achievementRowMapper);
        for (Achievement achievement : achievements) {
            achievement.loadFile();
        }
        return achievements;
    }

    @Override
    public List<RecommendationLetter> getRecommendationLetters(Long id) {
        return jdbcTemplate.query(SQL_SELECT_RECOMMENDATION_LETTERS, new Object[]{id}, recommendationLetterRowMapper);
    }

    @Override
    public void save(Student model) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(dataSource -> {
            PreparedStatement statement = dataSource.prepareStatement(SQL_INSERT);
            statement.setString(1, model.getLogin());
            statement.setString(2, model.getPassword());
            statement.setString(3, model.getEmail());
            statement.setString(4, model.getName());
            statement.setString(5, model.getLastName());
            statement.setString(6, model.getPatronymic());
            statement.setDate(7, (Date) model.getBirthDate());
            statement.setString(8, model.getEducationalLevel());
            statement.setString(9, model.getUniversity());
            statement.setString(10, model.getFaculty());
            statement.setString(11, model.getSpecialization());
            statement.setString(12, model.getEducationEndYear());
            statement.setString(13, model.getCity());
            statement.setString(14, model.getCitizenship());
            statement.setString(15, model.getGender());
            statement.setString(16, model.getAbout());
            statement.setString(17, model.getLinkToGit());
            statement.setString(18, model.getWorkSchedule());
            statement.setString(19, model.getMove());
            statement.setBoolean(20, model.getWorkSearching());
            statement.setString(21, String.valueOf(Role.TEACHER));
            statement.setString(22, String.valueOf(State.NOT_CONFIRMED));
            return statement;
        }, keyHolder);
        model.setId((Long) keyHolder.getKey());
    }

    @Override
    public void update(Student model) {
        jdbcTemplate.update(dataSource -> {
            PreparedStatement statement = dataSource.prepareStatement(SQL_UPDATE);
            statement.setString(1, model.getLogin());
            statement.setString(2, model.getPassword());
            statement.setString(3, model.getEmail());
            statement.setString(4, model.getName());
            statement.setString(5, model.getLastName());
            statement.setString(6, model.getPatronymic());
            statement.setDate(7, (Date) model.getBirthDate());
            statement.setString(8, model.getEducationalLevel());
            statement.setString(9, model.getUniversity());
            statement.setString(10, model.getFaculty());
            statement.setString(11, model.getSpecialization());
            statement.setString(12, model.getEducationEndYear());
            statement.setString(13, model.getCity());
            statement.setString(14, model.getCitizenship());
            statement.setString(15, model.getGender());
            statement.setString(16, model.getAbout());
            statement.setString(17, model.getLinkToGit());
            statement.setString(18, model.getWorkSchedule());
            statement.setString(19, model.getMove());
            statement.setBoolean(20, model.getWorkSearching());
            statement.setString(21, String.valueOf(Role.TEACHER));
            statement.setString(22, String.valueOf(State.NOT_CONFIRMED));
            statement.setLong(23, model.getId());
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
    public Optional<Student> find(Long id) {
        try {
            Student student = jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, new Object[]{id}, studentRowMapper);
            Optional<StudentImage> optionalStudentImage = getImage(student.getId());
            optionalStudentImage.ifPresent(student::setImage);
            setAttributes(student);
            return Optional.ofNullable(student);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = jdbcTemplate.query(SQL_SELECT_ALL, studentRowMapper);
        for (Student student : students) {
            Optional<StudentImage> optionalStudentImage = getImage(student.getId());
            optionalStudentImage.ifPresent(student::setImage);
            setAttributes(student);
        }
        return students;
    }

    private void setAttributes(Student student) {
        student.setSkills(getSkills(student.getId()));
        student.setLanguages(getLanguages(student.getId()));
        student.setWorkExperiences(getWorkExperience(student.getId()));
        student.setAchievements(getAchievements(student.getId()));
        student.setRecommendationLetters(getRecommendationLetters(student.getId()));
    }
}
