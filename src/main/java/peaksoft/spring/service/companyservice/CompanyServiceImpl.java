package peaksoft.spring.service.companyservice;

import org.springframework.stereotype.Service;
import peaksoft.spring.models.Company;
import peaksoft.spring.models.Course;
import peaksoft.spring.repositroy.companydao.CompanyDAO;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService{

    private final CompanyDAO companyDAO;

    public CompanyServiceImpl(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    @Override
    public List<Company> getAllCompany() {
        return companyDAO.getAllCompany();
    }

    @Override
    public void addCompany(Company company) {
        companyDAO.addCompany(company);
    }

    @Override
    public Company getCompanyByID(Long id) {
        return companyDAO.getCompanyByID(id);
    }

    @Override
    public void updateCompany(Long id, Company updatedCompany) {
        companyDAO.updateCompany(id, updatedCompany);
    }

    @Override
    public void deleteCompany(Long id) {
        companyDAO.deleteCompany(id);
    }

    @Override
    public void addCourseToCompany(Long courseId, Long companyId) {
        companyDAO.addCourseToCompany(courseId, companyId);
    }


}
