package peaksoft.spring.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lessons")
@Getter @Setter
@NoArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lesson_gen")
    @SequenceGenerator(name = "lesson_gen", sequenceName = "lesson_seq", allocationSize = 1)
    private Long id;
    private String lessonName;

    @OneToMany
    private List<Task> tasks;

    @OneToOne
    private Video video;
}
