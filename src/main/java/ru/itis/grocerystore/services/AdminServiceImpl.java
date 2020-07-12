package ru.itis.grocerystore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.grocerystore.dto.CompanyDto;
import ru.itis.grocerystore.models.Company;
import ru.itis.grocerystore.repositories.CompaniesRepository;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private CompaniesRepository companiesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void createCompany(CompanyDto companyDto) {
        Company company = Company.builder()
                .login(companyDto.getLogin())
                .password(passwordEncoder.encode(companyDto.getPassword()))
                .build();
        if (!companiesRepository.findByLogin(companyDto.getLogin()).isPresent())
            companiesRepository.save(company);
        else throw new IllegalArgumentException("User with this Login already exist");
    }
}
