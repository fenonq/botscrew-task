package com.fenonq.botscrewtask.service;

import com.fenonq.botscrewtask.exception.EntityNotFoundException;

public interface UniversityService {

    String showHeadOfDepartmentByName(String departmentName) throws EntityNotFoundException;

    String showStatisticsByDepartmentName(String departmentName) throws EntityNotFoundException;

    String showAvgSalaryByDepartmentName(String departmentName) throws EntityNotFoundException;

    String showEmployeeCountByDepartmentName(String departmentName) throws EntityNotFoundException;

    String globalSearch(String template) throws EntityNotFoundException;

}
