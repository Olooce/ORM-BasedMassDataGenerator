package oloo.mass_data_generator.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "bank_details")
public class BankDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;

    private String bankName;

    private String accountNumber;

    private String ifscCode;

    // Getters and setters
}
