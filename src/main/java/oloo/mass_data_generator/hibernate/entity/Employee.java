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

    // Constructors
    public Employee() {
    }

    public Employee(String name, Date dob, String gender, Long departmentId, String employmentType, Date employmentDate) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.departmentId = departmentId;
        this.employmentType = employmentType;
        this.employmentDate = employmentDate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    // toString method (optional for debugging)
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                ", departmentId=" + departmentId +
                ", employmentType='" + employmentType + '\'' +
                ", employmentDate=" + employmentDate +
                '}';
    }
}
