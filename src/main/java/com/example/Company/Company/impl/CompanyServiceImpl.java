package com.example.Company.Company.impl;


import com.example.Company.Company.Company;
import com.example.Company.Company.CompanyRepository;
import com.example.Company.Company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public void addCompany(Company company) {
         companyRepository.save(company);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, long id) {
        Optional<Company> findCompany = companyRepository.findById(id);
        if(findCompany.isPresent()){
            Company updatedCompany=findCompany.get();
            updatedCompany.setDescription(company.getDescription());
            updatedCompany.setName(company.getName());
            companyRepository.save(updatedCompany);
            return  true;
        }
        return false;
    }

    @Override
    public Company getCompanyById(long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCompanyById(long id) {
        Optional<Company> findCompany = companyRepository.findById(id);
        if(findCompany.isPresent()){
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
