package peaksoft.spring.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tasks")
@Getter @Setter
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "task_gen")
    @SequenceGenerator(name = "task_gen", sequenceName = "task_seq", allocationSize = 1)
    private Long id;
    private String taskName;
    private String taskText;
    private Date deadLine;

    @OneToOne
    private Lesson lesson;

}
