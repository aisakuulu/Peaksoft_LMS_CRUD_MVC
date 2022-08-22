package peaksoft.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.spring.models.Company;
import peaksoft.spring.service.companyservice.CompanyService;

import java.util.List;

@Controller
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }


    @GetMapping
    public String getAllCompanies(Model model){
        List<Company> companies = companyService.getAllCompany();
        model.addAttribute("companiesAttribute", companies);
        return "company/show-companies";
    }

    @GetMapping("/new")
    public String displayCompanyForm(Model model){
        Company newCompany = new Company();
        model.addAttribute("companyAttribute", newCompany);
        return "company/new-company";
    }

    @PostMapping("/save")
    public String createCompany(@ModelAttribute("companyAttribute") Company company){
        companyService.addCompany(company);
        return "redirect:/companies";
    }

    @GetMapping("/{id}/edit")
    public String displayCompanyEditForm(@PathVariable("id") Long id, Model model){
        Company company = companyService.getCompanyByID(id);
        model.addAttribute("companyInfo", company);
        return "company/edit-company";
    }

    @PostMapping("/{id}")
    public String updatedCompany(@ModelAttribute("companyInfo") Company company,
                                 @PathVariable("id") Long id){
        companyService.updateCompany(id, company);
        return "redirect:/companies";
    }

    @PostMapping("/delete/{companyID}")
    public String deleteCompany(@PathVariable Long companyID){
        companyService.deleteCompany(companyID);
        return "redirect:/companies";
    }
}
