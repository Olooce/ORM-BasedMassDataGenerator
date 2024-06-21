package oloo.mass_data_generator.hibernate.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "taxes")
public class Tax {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "month")
    private Date month;

    @Column(name = "gross_salary")
    private Double grossSalary;

    @Column(name = "tax_name")
    private String taxName;

    @Column(name="tax_rate")
    private Double taxRate;

    @Column(name="tax_type")
    private String taxType;

    @Column(name="tax_amount")
    private Double taxAmount;

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

   public void setGrossSalary(Double grossSalary){
        this.grossSalary = grossSalary;
   }
   private Double getGrossSalary(){
        return grossSalary;
   }

   public void setTaxName(String taxName) {
        this.taxName = taxName;
   }
   public String getTaxName() {
        return taxName;
   }

   public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
   }
   private Double getTaxRate(){
        return taxRate;
   }

   public void setTaxType(String taxType) {
        this.taxType = taxType;
   }
   private String getTaxType(){
        return taxType;
   }

   public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
   }
}
