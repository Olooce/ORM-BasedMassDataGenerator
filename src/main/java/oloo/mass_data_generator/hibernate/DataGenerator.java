package com.example.hibernate;

import com.github.javafaker.Faker;
import com.example.hibernate.dao.*;
import com.example.hibernate.entity.*;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DataGenerator {
    private static final Faker faker = new Faker();

    public static Employee generateEmployee() {
        Employee employee = new Employee();
        employee.setName(faker.name().fullName());
        employee.setDob(faker.date().birthday());
        employee.setGender(faker.demographic().sex());
        employee.setDepartmentId(faker.number().numberBetween(1L, 10L));
        employee.setEmploymentType(faker.company().profession());
        employee.setEmploymentDate(faker.date().past(3650, TimeUnit.DAYS));
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

    public static Salary generateSalary(Long employeeId) {
        Salary salary = new Salary();
        salary.setEmployeeId(employeeId);
        salary.setAmount(faker.number().randomDouble(2, 30000, 150000));
        salary.setPayPeriod("Monthly");
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
        bankDetails.setBankName(faker.bank().name());
        bankDetails.setAccountNumber(faker.finance().iban());
        bankDetails.setIfscCode(faker.finance().bic());
        return bankDetails;
    }
}
