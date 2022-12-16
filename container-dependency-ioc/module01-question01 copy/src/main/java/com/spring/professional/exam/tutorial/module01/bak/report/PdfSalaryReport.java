package com.spring.professional.exam.tutorial.module01.bak.report;

import com.spring.professional.exam.tutorial.module01.bak.ds.EmployeeSalary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("pdf-reports")
public class PdfSalaryReport implements SalaryReport{
    @Override
    public void writeReport(List<EmployeeSalary> employeeSalaries) {
        System.out.println("Writing Pdf Report");
    }
}
