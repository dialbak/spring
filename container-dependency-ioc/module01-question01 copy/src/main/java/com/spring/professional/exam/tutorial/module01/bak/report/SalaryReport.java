package com.spring.professional.exam.tutorial.module01.bak.report;

import com.spring.professional.exam.tutorial.module01.bak.ds.EmployeeSalary;

import java.util.List;

public interface SalaryReport {
    void writeReport(List<EmployeeSalary> employeeSalaries);
}
