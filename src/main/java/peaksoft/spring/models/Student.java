package peaksoft.spring.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.spring.enums.StudyFormat;

import javax.persistence.*;

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
}
