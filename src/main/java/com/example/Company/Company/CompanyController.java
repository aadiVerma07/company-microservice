package com.example.Company.Company;


import com.example.Company.Company.impl.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private CompanyServiceImpl companyService;
    @PostMapping
    ResponseEntity<String> addCompany(@RequestBody Company company){
        companyService.addCompany(company);
        return new ResponseEntity<>("Company Added Successfully ....",HttpStatus.CREATED);
    }
    @GetMapping
    ResponseEntity<List<Company>>getAllCompanies(){
        return new ResponseEntity<>(companyService.getAllCompanies(),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    ResponseEntity<String> updateCompany(@RequestBody Company company, @PathVariable long id) {
        boolean isUpdated = companyService.updateCompany(company, id);
        if (isUpdated) {
            return new ResponseEntity<>("Company Update Successfully...", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Company Not Found  ....", HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{id}")
    ResponseEntity<Company>getCompanyById(@PathVariable long id){
        Company companyById = companyService.getCompanyById(id);
        if(companyById !=null){
            return new ResponseEntity<>(companyById,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @DeleteMapping("/{id}")
    ResponseEntity<String>deleteCompanyById(@PathVariable long id) {
        boolean isDeleted = companyService.deleteCompanyById(id);
        if (isDeleted) {
            return new ResponseEntity<>("Company Deleted Successfully  ....", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Company Not Found  ....", HttpStatus.NOT_FOUND);
        }
    }

}
