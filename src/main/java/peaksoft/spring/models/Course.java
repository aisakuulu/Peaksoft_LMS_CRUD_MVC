package peaksoft.spring.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Getter @Setter
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "course_gen")
    @SequenceGenerator(name = "course_gen",
            sequenceName = "course_seq",
            allocationSize = 1)
    private Long id;
    private String courseName;
    private Date dateOfStart;
    private int duration;
    private String image;
    private String description;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company theCompany;

    @ManyToMany
    private List<Instructor> instructors;

    @OneToMany
    private List<Student> students;

    @OneToMany
    private List<Lesson> lessons;
}
