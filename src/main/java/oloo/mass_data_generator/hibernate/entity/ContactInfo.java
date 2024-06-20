package oloo.mass_data_generator.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "contact_info")
public class ContactInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    private String phoneNumber;

    private String email;

    private Long employeeId;

    // Getters and setters
}
