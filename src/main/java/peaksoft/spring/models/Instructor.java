package peaksoft.spring.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "instructors")
@Getter @Setter
@NoArgsConstructor
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "instructor_gen")
    @SequenceGenerator(name = "instructor_gen",
            sequenceName = "instructor_seq",
            allocationSize = 1)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String specialization;

    @ManyToMany
    private List<Course> courses;
}
