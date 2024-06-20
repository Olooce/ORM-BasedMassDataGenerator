package oloo.mass_data_generator.hibernate;

import oloo.mass_data_generator.hibernate.dao.*;
import oloo.mass_data_generator.hibernate.entity.*;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        ContactInfoDAO contactInfoDAO = new ContactInfoDAO();
        SalaryDAO salaryDAO = new SalaryDAO();
        AllowanceDAO allowanceDAO = new AllowanceDAO();
        DeductionDAO deductionDAO = new DeductionDAO();
        TaxDAO taxDAO = new TaxDAO();
        BankDetailsDAO bankDetailsDAO = new BankDetailsDAO();

        for (int i = 0; i < 10; i++) {
            Employee employee = DataGenerator.generateEmployee();
            employeeDAO.save(employee);

            ContactInfo contactInfo = DataGenerator.generateContactInfo(employee.getId());
            contactInfoDAO.save(contactInfo);

            Salary salary = DataGenerator.generateSalary(employee.getId());
            salaryDAO.save(salary);

            Allowance allowance = DataGenerator.generateAllowance(employee.getId());
            allowanceDAO.save(allowance);

            Deduction deduction = DataGenerator.generateDeduction(employee.getId());
            deductionDAO.save(deduction);

            Tax tax = DataGenerator.generateTax(employee.getId());
            taxDAO.save(tax);

            BankDetails bankDetails = DataGenerator.generateBankDetails(employee.getId());
            bankDetailsDAO.save(bankDetails);
        }

        HibernateUtil.getSessionFactory().close();
    }
}
