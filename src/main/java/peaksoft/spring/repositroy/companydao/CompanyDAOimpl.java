package peaksoft.spring.repositroy.companydao;

import org.springframework.stereotype.Repository;
import peaksoft.spring.models.Company;
import peaksoft.spring.models.Course;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class CompanyDAOimpl implements CompanyDAO{


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Company> getAllCompany() {

        return entityManager.
                createQuery("SELECT com FROM Company  com", Company.class).getResultList();
    }

    @Override
    public void addCompany(Company company) {
        entityManager.persist(company);
    }

    @Override
    public Company getCompanyByID(Long id) {
        return entityManager.find(Company.class, id);
    }

    @Override
    public void updateCompany(Long id, Company updatedCompany) {
        Company company = entityManager.find(Company.class, id);
        company.setCompanyName(updatedCompany.getCompanyName());
        company.setLocatedCountry(updatedCompany.getLocatedCountry());
        entityManager.merge(company);
    }

    @Override
    public void deleteCompany(Long id) {
        Company company = entityManager.find(Company.class, id);
        entityManager.remove(company);
    }

    @Override
    public void addCourseToCompany(Long courseId, Long companyId) {

        Course course = entityManager.find(Course.class, courseId);
        Company company = entityManager.find(Company.class, companyId);
        company.addCourse(course);
        entityManager.merge(company);
    }


}
