package oloo.mass_data_generator.hibernate;

import oloo.mass_data_generator.hibernate.dao.*;
import oloo.mass_data_generator.hibernate.entity.*;
import com.github.javafaker.Faker;

import java.sql.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        ContactInfoDAO contactInfoDAO = new ContactInfoDAO();
        SalaryDAO salaryDAO = new SalaryDAO();
        AllowanceDAO allowanceDAO = new AllowanceDAO();
        DeductionDAO deductionDAO = new DeductionDAO();
        TaxDAO taxDAO = new TaxDAO();
        BankDetailsDAO bankDetailsDAO = new BankDetailsDAO();
        Faker faker = new Faker();
        Random random = new Random();
        String employeeName;
        String employeeEmail;
        String employeePhone;
        String employeeAddress;
        Date employeeDob;
        double basicSalary,grossSalary;
        long departmentId;
        String employmentType;
        Date employmentDate;
        String gender;
        Date month;
        double totalTaxes;
        String deductionName;
        double deductionAmount;
        double totalAllowances = 0;

        String bankName,accountNo,branchCode;

        for (int i = 0; i < 1; i++) {
            employeeName = faker.name().fullName();
            employeeEmail = faker.internet().emailAddress();
            employeePhone = faker.phoneNumber().phoneNumber();
            employeeAddress = faker.address().fullAddress();
            employeeDob = convertToSqlDate((faker.date().birthday()));
            departmentId = ((long) (Math.random() * 10) + 1);
            employmentType = faker.options().option("PART-TIME", "FULL-TIME", "CONTRACT");
            employmentDate = new java.sql.Date(faker.date().past(10*365, TimeUnit.DAYS).getTime());
            gender = faker.demographic().sex();
            basicSalary = random.nextDouble() * (2000000 - 50000) + 50000;
            bankName = faker.company().name();
            accountNo = faker.finance().iban();
            branchCode = faker.finance().bic();
            deductionAmount = random.nextDouble() * (50000 - 5000) + 500;

            Employee employee = DataGenerator.generateEmployee(employeeName, employeeDob,departmentId, employmentType, employmentDate, gender);
            employeeDAO.save(employee);

            ContactInfo contactInfo = DataGenerator.generateContactInfo(employee.getId(), employeeAddress, employeePhone, employeeEmail);
            contactInfoDAO.save(contactInfo);

            deductionName = faker.options().option("NHIF", "NSSF", "PENSION");
            for( int j = 0; j <3 ;j++) {
                month = new java.sql.Date(faker.date().past(10*365, TimeUnit.DAYS).getTime());

                Allowance allowance = DataGenerator.generateAllowance(employee.getId(), 0.03, basicSalary, "House Allowance", month, "PERCENTAGE", basicSalary * 0.03);
                allowanceDAO.save(allowance);
                totalAllowances += basicSalary * 0.03;
                allowance = DataGenerator.generateAllowance(employee.getId(), 0.015, basicSalary, "Transport Allowance", month, "PERCENTAGE", basicSalary * 0.015);
                allowanceDAO.save(allowance);
                totalAllowances += basicSalary * 0.03;
                DataGenerator.generateAllowance(employee.getId(), 0.02, basicSalary, "Mortgage Allowance", month, "PERCENTAGE", basicSalary * 0.02);
                allowanceDAO.save(allowance);

                Deduction deduction = DataGenerator.generateDeduction(employee.getId(), month, deductionAmount, deductionName,"FIXED");
                deductionDAO.save(deduction);

                grossSalary = (basicSalary + totalAllowances) - deductionAmount;
                Tax tax = DataGenerator.generateTax(employee.getId(), month, grossSalary, "PAYE", 0.14, "PERCENTAGE", grossSalary * 0.14);
                taxDAO.save(tax);

                totalTaxes = grossSalary * 0.14;
                Salary salary = DataGenerator.generateSalary(employee.getId(),month, totalAllowances, deductionAmount, grossSalary, totalTaxes, basicSalary);
                salaryDAO.save(salary);

                basicSalary = basicSalary * 1.02;
            }

            BankDetails bankDetails = DataGenerator.generateBankDetails(employee.getId(), bankName, accountNo, branchCode);
            bankDetailsDAO.save(bankDetails);
        }

        HibernateUtil.getSessionFactory().close();
    }

    private static Date convertToSqlDate(java.util.Date birthday) {
        return new java.sql.Date(birthday.getTime());
    }
}
