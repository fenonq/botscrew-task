package com.fenonq.botscrewtask.service;

public interface UniversityService {

    String showHeadOfDepartmentByName(String departmentName);

    String showStatisticsByDepartmentName(String departmentName);

    String showAvgSalaryByDepartmentName(String departmentName);

    String showEmployeeCountByDepartmentName(String departmentName);

    String globalSearch(String template);

}
