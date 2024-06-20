package oloo.mass_data_generator.hibernate.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Temporal(TemporalType.DATE)
    private Date dob;

    private String gender;

    private Long departmentId;

    private String employmentType;

    @Temporal(TemporalType.DATE)
    private Date employmentDate;

    // Getters and setters
}
