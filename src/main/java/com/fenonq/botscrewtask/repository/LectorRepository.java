package com.fenonq.botscrewtask.repository;

import com.fenonq.botscrewtask.model.Lector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface LectorRepository extends JpaRepository<Lector, Long> {

    Lector findByMainDepartmentName(String mainDepartmentName);

    Set<Lector> findAllByNameContainsOrSurnameContains(String name, String surname);

}
