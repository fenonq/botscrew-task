package com.fenonq.botscrewtask.service.impl;

import com.fenonq.botscrewtask.exception.EntityNotFoundException;
import com.fenonq.botscrewtask.model.enums.Degree;
import com.fenonq.botscrewtask.model.Lector;
import com.fenonq.botscrewtask.repository.DepartmentRepository;
import com.fenonq.botscrewtask.repository.LectorRepository;
import com.fenonq.botscrewtask.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UniversityServiceImpl implements UniversityService {

    private final LectorRepository lectorRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public String showHeadOfDepartmentByName(String departmentName) {
        validateDepartment(departmentName);
        Lector headLector = lectorRepository.findByMainDepartmentName(departmentName);
        return String.format("Head of %s department is %s %s.",
                departmentName, headLector.getName(), headLector.getSurname());
    }

    @Override
    public String showStatisticsByDepartmentName(String departmentName) {
        validateDepartment(departmentName);
        Long countAssistants =
                departmentRepository
                        .countEmployeesByDepartmentNameAndDegree(departmentName, Degree.ASSISTANT);

        Long countAssociateProfessors =
                departmentRepository
                        .countEmployeesByDepartmentNameAndDegree(departmentName, Degree.ASSOCIATE_PROFESSOR);

        Long countProfessors =
                departmentRepository
                        .countEmployeesByDepartmentNameAndDegree(departmentName, Degree.PROFESSOR);

//        ====== DIFFERENT WAY: ======

//        Department department = departmentRepository.findByName(departmentName);
//
//        Long countAssistants = department.getLectors().stream()
//                .filter(lector -> lector.getDegree().equals(Degree.ASSISTANT))
//                .count();
//
//        Long countAssociateProfessors = department.getLectors().stream()
//                .filter(lector -> lector.getDegree().equals(Degree.ASSOCIATE_PROFESSOR))
//                .count();
//
//        Long countProfessors = department.getLectors().stream()
//                .filter(lector -> lector.getDegree().equals(Degree.PROFESSOR))
//                .count();

        return String.format("assistants - %d.\n" +
                "associate professors - %d.\n" +
                "professors - %d.", countAssistants, countAssociateProfessors, countProfessors);
    }

    @Override
    public String showAvgSalaryByDepartmentName(String departmentName) {
        validateDepartment(departmentName);
        BigDecimal avgSalary = departmentRepository.averageSalaryByDepartmentName(departmentName);
        return String.format("The average salary of %s is %g.", departmentName, avgSalary);
    }

    @Override
    public String showEmployeeCountByDepartmentName(String departmentName) {
        validateDepartment(departmentName);
        Long countEmployees = departmentRepository.countEmployeesByDepartmentName(departmentName);
        return countEmployees.toString();
    }

    @Override
    public String globalSearch(String template) {
        Set<Lector> foundedLectors = lectorRepository.findAllByNameContainsOrSurnameContains(template, template);
        String result = foundedLectors.stream()
                .map(lector -> lector.getName() + " " + lector.getSurname())
                .collect(Collectors.joining(", "));
        if (result.isBlank()) {
            throw new EntityNotFoundException("Nothing found!");
        }
        return result;
    }

    private void validateDepartment(String departmentName) {
        if (departmentRepository.findByName(departmentName) == null) {
            throw new EntityNotFoundException(String.format("Department %s not found!", departmentName));
        }
    }

}
