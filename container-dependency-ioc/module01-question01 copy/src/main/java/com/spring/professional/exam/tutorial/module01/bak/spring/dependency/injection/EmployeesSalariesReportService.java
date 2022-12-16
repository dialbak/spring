package com.spring.professional.exam.tutorial.module01.bak.spring.dependency.injection;

import com.spring.professional.exam.tutorial.module01.bak.bls.EmployeeSalaryCalculator;
import com.spring.professional.exam.tutorial.module01.bak.dao.EmployeeDao;
import com.spring.professional.exam.tutorial.module01.bak.ds.Employee;
import com.spring.professional.exam.tutorial.module01.bak.ds.EmployeeSalary;
import com.spring.professional.exam.tutorial.module01.bak.report.SalaryReport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesSalariesReportService {
    // Dependencies required
    private final EmployeeDao employeeDao;
    private final EmployeeSalaryCalculator employeeSalaryCalculator;
    private final SalaryReport salaryReport;

    public EmployeesSalariesReportService(EmployeeDao employeeDao, EmployeeSalaryCalculator employeeSalaryCalculator, SalaryReport salaryReport) {
        this.employeeDao = employeeDao;
        this.employeeSalaryCalculator = employeeSalaryCalculator;
        this.salaryReport = salaryReport;
    }

    void generateReport() {
        List<Employee> employees = employeeDao.findAll();
        List<EmployeeSalary> employeeSalaries = employeeSalaryCalculator.calculateSalaries(employees);

        salaryReport.writeReport(employeeSalaries);
    }
}
