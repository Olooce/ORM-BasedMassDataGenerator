package oloo.mass_data_generator.hibernate.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "deductions")
public class Deduction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name="month")
    private Date month;

    @Column(name="deduction_name")
    private String deductionName;

    @Column(name = "deduction_amount")
    private Double deductionAmount;

    @Column(name = "deduction_type")
    private String deductionType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setMonth(Date month) {
        this.month = month;
    }
    public Date getMonth() {
        return month;
    }

    public void setDeductionName(String deductionName) {
        this.deductionName = deductionName;
    }
    public String getDeductionName() {
        return deductionName;
    }

    public void setDeductionAmount(Double deductionAmount) {
        this.deductionAmount = deductionAmount;
    }
    public Double getDeductionAmount() {
        return deductionAmount;
    }

    public void setDeductionType(String deductionType) {
        this.deductionType = deductionType;
    }
    public String getDeductionType() {
        return deductionType;
    }


}
