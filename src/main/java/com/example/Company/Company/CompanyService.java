package com.example.Company.Company;

import java.util.List;

public interface CompanyService {
    void addCompany(Company company);
    List<Company>getAllCompanies();
    boolean updateCompany(Company company,long id);
    Company getCompanyById(long id);
    boolean deleteCompanyById(long id);
}
