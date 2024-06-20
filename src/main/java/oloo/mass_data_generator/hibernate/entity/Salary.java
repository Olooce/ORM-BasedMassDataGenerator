package oloo.mass_data_generator.hibernate.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "salary")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "month")
    private Date currentMonth;

    @Column(name = "basic_salary")
    private Double basicSalary;

    @Column(name="total_allowances")
    private Double totalAllowances;

    @Column(name="total_deductions")
    private Double totalDeductions;

    @Column(name="total_gross_earnings")
    private Double totalEarnings;

    @Column (name="tax_relief")
    private Double taxRelief;

    @Column (name="total_taxes")
    private Double totalTaxes;

    @Column (name="net_salary")
    private Double netSalary;



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

    public Double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Double amount) {
        this.basicSalary = amount;
    }

    public Date getMonth() {
        return currentMonth;
    }

    public void setMonth(Date currentMonth) {
        this.currentMonth = currentMonth;
    }

    public void setTotalAllowances(Double totalAllowances) {
        this.totalAllowances = totalAllowances;
    }
    public Double getTotalAllowances() {
        return totalAllowances;
    }

    public void setTotalDeductions(Double totalDeductions) {
        this.totalDeductions = totalDeductions;
    }
    public Double getTotalDeductions() {
        return totalDeductions;
    }

    public void setTotalEarnings(Double totalEarnings) {
        this.totalEarnings = totalEarnings;
    }
    public Double getTotalEarnings() {
        return totalEarnings;
    }

    public void setTaxRelief(Double taxRelief) {
        this.taxRelief = taxRelief;
    }
    public Double getTaxRelief() {
        return taxRelief;
    }

    public void setTotalTaxes(Double totalTaxes) {
        this.totalTaxes = totalTaxes;
    }
    public Double getTotalTaxes() {
        return totalTaxes;
    }

    public void setNetSalary(Double netSalary) {
        this.netSalary = netSalary;
    }
    public Double getNetSalary() {
        return netSalary;
    }


}
