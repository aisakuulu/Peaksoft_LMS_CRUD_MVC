package peaksoft.spring.repositroy.companydao;

import peaksoft.spring.models.Company;
import peaksoft.spring.models.Course;

import java.util.List;

public interface CompanyDAO {

    List<Company> getAllCompany();

    void addCompany(Company company);

    Company getCompanyByID(Long id);

    void updateCompany(Long id, Company updatedCompany);

    void deleteCompany(Long id);

    void addCourseToCompany(Long courseId, Long companyId);
}
