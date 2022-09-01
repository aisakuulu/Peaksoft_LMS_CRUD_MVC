package peaksoft.spring.models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
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

    @OneToMany(mappedBy = "theCompany", cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    private List<Course> courses;

    public void addCourse(Course course){
        if (courses == null){
            courses = new ArrayList<>();
        } else{
            this.courses.add(course);
        }
    }
    @OneToMany(mappedBy = "theCompany", cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    private List<Instructor> instructors;

    public void addInstructor(Instructor instructor) {
        if(instructors == null) {
            instructors = new ArrayList<>();
        } else {
            this.instructors.add(instructor);
        }
    }

    @OneToMany(mappedBy = "theCompany")
    private List<Student> students;

    public void addStudent(Student student) {
        if(students == null) {
            students=new ArrayList<>();
        } else {
            this.students.add(student);
        }
    }
}
