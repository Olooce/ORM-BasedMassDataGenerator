package oloo.mass_data_generator.hibernate;

import com.github.javafaker.Faker;
import oloo.mass_data_generator.hibernate.entity.*;

import java.sql.Date;

public class DataGenerator {
    private static final Faker faker = new Faker();

    public static Employee generateEmployee(String name,Date dob, Long departmentId, String type, Date date, String gender) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setDob(dob);
        employee.setGender(gender);
        employee.setDepartmentId(departmentId);
        employee.setEmploymentType(type);
        employee.setEmploymentDate(date);
        return employee;
    }

    public static ContactInfo generateContactInfo(Long employeeId, String address, String number, String email) {
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setEmployeeId(employeeId);
        contactInfo.setAddress(address);
        contactInfo.setPhoneNumber(number);
        contactInfo.setEmail(email);
        return contactInfo;
    }

    public static Salary generateSalary(Long employeeId, Date month, Double totalAllowances, Double totalDeductions, Double grossSalary, Double totalTaxes, Double basicSalary) {
        Salary salary = new Salary();
        salary.setEmployeeId(employeeId);
        salary.setBasicSalary(basicSalary);
        salary.setMonth(month);
        salary.setTotalAllowances(totalAllowances);
        salary.setTotalDeductions(totalDeductions);
        salary.setTotalEarnings(grossSalary);
        salary.setTotalTaxes(totalTaxes);
        salary.setNetSalary(grossSalary - totalAllowances);
        return salary;
    }

    public static Allowance generateAllowance(Long employeeId, Double rate, Double grossSalary, String allowanceName, Date month, String allowanceType, Double allowanceAmount) {
        Allowance allowance = new Allowance();
        allowance.setEmployeeId(employeeId);
        allowance.setMonth(month);
        allowance.setAllowanceName(allowanceName);
        allowance.setAllowanceRate(rate);
        allowance.setAllowanceAmount(allowanceAmount);
        allowance.setAllowanceTypeType(allowanceType);
        return allowance;
    }

    public static Deduction generateDeduction(Long employeeId, Date month, Double deductionAmount, String deductionName, String deductionType) {
        Deduction deduction = new Deduction();
        deduction.setEmployeeId(employeeId);
        deduction.setMonth(month);
        deduction.setDeductionName(deductionName);
        deduction.setDeductionAmount(deductionAmount);
        deduction.setDeductionType(deductionType);
        return deduction;
    }

    public static Tax generateTax(Long employeeId, Date month, Double grossSalary, String taxName, Double taxRate, String taxType, Double taxAmount) {
        Tax tax = new Tax();
        tax.setEmployeeId(employeeId);
        tax.setMonth(month);
        tax.setGrossSalary(grossSalary);
        tax.setTaxName(taxName);
        tax.setTaxRate(taxRate);
        tax.setTaxType(taxType);
        tax.setTaxAmount(taxAmount);
        return tax;
    }

    public static BankDetails generateBankDetails(Long employeeId, String bankName, String accountNo, String branchCode) {
        BankDetails bankDetails = new BankDetails();
        bankDetails.setEmployeeId(employeeId);
        bankDetails.setBankName(bankName);
        bankDetails.setAccountNumber(accountNo);
        bankDetails.setBranchCode(branchCode);
        return bankDetails;
    }
}
