package peaksoft.spring.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies")
@Getter @Setter
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "company_gen")
    @SequenceGenerator(name = "company_gen",
            sequenceName = "company_seq",
            allocationSize = 1)
    private Long id;

    private String companyName;

    private String locatedCountry;

    @OneToMany(mappedBy = "theCompany")
    private List<Course> courses;

    @OneToMany(mappedBy = "theCompany")
    private List<Student> students;

}
