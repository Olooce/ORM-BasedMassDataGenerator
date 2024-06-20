package oloo.mass_data_generator.hibernate;

import com.github.javafaker.Faker;
import oloo.mass_data_generator.hibernate.entity.*;

import java.sql.Date;
import java.util.concurrent.TimeUnit;

public class DataGenerator {
    private static final Faker faker = new Faker();

    public static Employee generateEmployee() {
        Employee employee = new Employee();
        employee.setName(faker.name().fullName());
        employee.setDob(faker.date().birthday());
        employee.setGender(faker.demographic().sex());
        employee.setDepartmentId(faker.number().numberBetween(1L, 10L));
        employee.setEmploymentType(faker.options().option("FULL-TIME", "PART-TIME","CONTRACT","TEMPORARY"));
        employee.setEmploymentDate(faker.date().past(365, TimeUnit.DAYS));
        return employee;
    }

    public static ContactInfo generateContactInfo(Long employeeId) {
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setEmployeeId(employeeId);
        contactInfo.setAddress(faker.address().fullAddress());
        contactInfo.setPhoneNumber(faker.phoneNumber().phoneNumber());
        contactInfo.setEmail(faker.internet().emailAddress());
        return contactInfo;
    }

    public static Salary generateSalary(Long employeeId, Date month) {
        Salary salary = new Salary();
        salary.setEmployeeId(employeeId);
        salary.setBasicSalary(faker.number().randomDouble(2, 30000, 150000));
        salary.setMonth(month);
        return salary;
    }

    public static Allowance generateAllowance(Long employeeId) {
        Allowance allowance = new Allowance();
        allowance.setEmployeeId(employeeId);
        allowance.setAmount(faker.number().randomDouble(2, 1000, 10000));
        allowance.setType(faker.job().field());
        return allowance;
    }

    public static Deduction generateDeduction(Long employeeId) {
        Deduction deduction = new Deduction();
        deduction.setEmployeeId(employeeId);
        deduction.setAmount(faker.number().randomDouble(2, 500, 5000));
        deduction.setType(faker.job().keySkills());
        return deduction;
    }

    public static Tax generateTax(Long employeeId) {
        Tax tax = new Tax();
        tax.setEmployeeId(employeeId);
        tax.setAmount(faker.number().randomDouble(2, 1000, 10000));
        tax.setType("Income Tax");
        return tax;
    }

    public static BankDetails generateBankDetails(Long employeeId) {
        BankDetails bankDetails = new BankDetails();
        bankDetails.setEmployeeId(employeeId);
        bankDetails.setBankName(faker.company().name());
        bankDetails.setAccountNumber(faker.finance().iban());
        bankDetails.setBranchCode(faker.finance().bic());
        return bankDetails;
    }
}
