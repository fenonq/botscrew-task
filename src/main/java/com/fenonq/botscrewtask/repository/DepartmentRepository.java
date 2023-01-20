package com.fenonq.botscrewtask.repository;

import com.fenonq.botscrewtask.model.enums.Degree;
import com.fenonq.botscrewtask.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByName(String name);

    @Query("select count(l) as avg from Department d inner join d.lectors l where d.name= ?1 and l.degree = ?2")
    Long countEmployeesByDepartmentNameAndDegree(String departmentName, Degree degree);

    @Query("select AVG(l.salary) as avg from Department d inner join d.lectors l where d.name= ?1")
    BigDecimal averageSalaryByDepartmentName(String departmentName);

    @Query("select count(l.name) as c from Department d inner join d.lectors l where d.name= ?1")
    Long countEmployeesByDepartmentName(String departmentName);

}
