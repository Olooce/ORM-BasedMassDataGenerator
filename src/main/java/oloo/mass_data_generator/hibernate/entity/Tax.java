package oloo.mass_data_generator.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "tax")
public class Tax {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;

    private Double amount;

    private String type;

    // Getters and setters
}
