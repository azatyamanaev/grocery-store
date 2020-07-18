package ru.itis.grocerystore.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.grocerystore.config.TestApplicationConfig;
import ru.itis.grocerystore.models.Company;
import ru.itis.grocerystore.models.Teacher;

public class CompaniesRepositoryJpaImplTest {

    private CompaniesRepository companiesRepository;

    @BeforeEach
    public void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestApplicationConfig.class);
        companiesRepository = context.getBean("companiesRepositoryJpaImpl", CompaniesRepository.class);
    }

    @Test
    public void whenSave_ThenTeacherIsPresent() {
        Company company = Company.builder()
                .name("Mera")
                .login("company")
                .about("good")
                .build();
        companiesRepository.save(company);
        assert companiesRepository.find(1L).isPresent();
    }

    @Test
    public void whenFind_thenReturnTeacher() {

        //given
        Company company = Company.builder()
                .name("Mera")
                .login("company")
                .about("good")
                .build();
        companiesRepository.save(company);

        //when
        Company found = companiesRepository.find(1L).get();

        //then
        assert found.getAbout().equals(company.getAbout());
    }

    @Test
    public void checkUpdate() {
        Company company = Company.builder()
                .name("Mera")
                .login("company")
                .about("good")
                .build();
        companiesRepository.save(company);
        String previousAbout = company.getAbout();
        company.setAbout("bad");
       companiesRepository.update(company);
        assert !companiesRepository.find(1L).get().getAbout().equals(previousAbout);
    }

    @Test
    public void whenSaveSeveral_thenSizeOfResultListMoreThanOne() {
        Company company = Company.builder()
                .name("Mera")
                .login("company")
                .about("good")
                .build();
        companiesRepository.save(company);
        companiesRepository.save(Company.builder()
                .name("SimbirSodt")
                .login("com")
                .about("very good")
                .build());
        assert companiesRepository.findAll().size() == 2;
    }
}
