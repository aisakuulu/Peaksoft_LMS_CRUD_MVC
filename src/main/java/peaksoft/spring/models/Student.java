package peaksoft.spring.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.spring.enums.StudyFormat;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "students")
@Getter @Setter
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "student_gen")
    @SequenceGenerator(name = "student_gen",
            sequenceName = "student_seq",
            allocationSize = 1)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private StudyFormat studyFormat;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company theCompany;

    @OneToOne
    private Course theCourse;

    @OneToMany
    private List<Lesson> lessons;
}
