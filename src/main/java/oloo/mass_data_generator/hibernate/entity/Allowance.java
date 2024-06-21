package oloo.mass_data_generator.hibernate.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "allowances")
public class Allowance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name="month")
    private Date month;

    @Column(name="allowance_name")
    private String allowanceName;

    @Column(name="allowance_rate")
    private double allowanceRate;

    @Column(name="allowance_type")
    private String allowanceType;

    @Column(name = "allowance_amount")
    private Double allowanceAmount;


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

    public Double getAllowanceAmount() {
        return allowanceAmount;
    }

    public void setAllowanceAmount(Double allowanceAmount) {
        this.allowanceAmount = allowanceAmount;
    }

    public String getAllowanceTypeType() {
        return allowanceType;
    }

    public void setAllowanceTypeType(String allowanceType) {
        this.allowanceType = allowanceType;
    }

    public Date getMonth() {
        return month;
    }
    public void setMonth(Date month) {
        this.month = month;
    }

    public String getAllowanceName() {
        return allowanceName;
    }
    public void setAllowanceName(String allowanceName) {
        this.allowanceName = allowanceName;
    }

    public double getAllowanceRate() {
        return allowanceRate;
    }
    public void setAllowanceRate(double allowanceRate) {
        this.allowanceRate = allowanceRate;
    }
}
