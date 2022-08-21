package peaksoft.spring.repositroy.companydao;

import org.springframework.stereotype.Repository;
import peaksoft.spring.models.Company;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CompanyDAOimpl implements CompanyDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Company> getAllCompany() {
        return entityManager.createQuery("SELECT com FROM Company  com", Company.class).getResultList();
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
        entityManager.getTransaction().begin();
        Company company = getCompanyByID(id);
        company.setCompanyName(updatedCompany.getCompanyName());
        company.setLocatedCountry(updatedCompany.getLocatedCountry());
        entityManager.merge(company);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteCompany(Long id) {
        Company company = entityManager.find(Company.class, id);
        entityManager.remove(company);
    }
}