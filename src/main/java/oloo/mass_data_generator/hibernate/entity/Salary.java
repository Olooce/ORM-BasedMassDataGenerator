package oloo.mass_data_generator.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "salary")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;

    private Double amount;

    private String payPeriod;

    // Getters and setters
}
