package com.fenonq.botscrewtask.util;

import com.fenonq.botscrewtask.model.Department;
import com.fenonq.botscrewtask.model.Lector;
import com.fenonq.botscrewtask.model.enums.Degree;
import com.fenonq.botscrewtask.repository.DepartmentRepository;
import com.fenonq.botscrewtask.repository.LectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class DataLoader {

    private final DepartmentRepository departmentRepository;
    private final LectorRepository lectorRepository;

    public void loadData() {
        Lector ivanPetrenko = Lector.builder()
                .name("Ivan")
                .surname("Petrenko")
                .degree(Degree.PROFESSOR)
                .salary(new BigDecimal(1400))
                .departments(new HashSet<>())
                .build();

        Lector petroIvanov = Lector.builder()
                .name("Petro")
                .surname("Ivanov")
                .degree(Degree.PROFESSOR)
                .salary(new BigDecimal(1500))
                .departments(new HashSet<>())
                .build();

        Lector assistantTnatsissa = Lector.builder()
                .name("Assistant")
                .surname("Tnatsissa")
                .degree(Degree.ASSISTANT)
                .salary(new BigDecimal(700))
                .departments(new HashSet<>())
                .build();

        Department ami = Department.builder()
                .name("AMI")
                .headOfDepartment(ivanPetrenko)
                .lectors(new HashSet<>())
                .build();

        ivanPetrenko.getDepartments().add(ami);
        petroIvanov.getDepartments().add(ami);
        assistantTnatsissa.getDepartments().add(ami);

        ami.getLectors().add(ivanPetrenko);
        ami.getLectors().add(petroIvanov);
        ami.getLectors().add(assistantTnatsissa);

        departmentRepository.save(ami);

        Lector tarasFenyk = Lector.builder()
                .name("Taras")
                .surname("Fenyk")
                .degree(Degree.PROFESSOR)
                .salary(new BigDecimal(1234))
                .departments(new HashSet<>())
                .build();

        Lector maksymMaksymiv = Lector.builder()
                .name("Maksym")
                .surname("Maksymiv")
                .degree(Degree.ASSOCIATE_PROFESSOR)
                .salary(new BigDecimal(1100))
                .departments(new HashSet<>())
                .build();

        Lector bohdanBohdaniv = Lector.builder()
                .name("Bohdan")
                .surname("Bohdaniv")
                .degree(Degree.ASSOCIATE_PROFESSOR)
                .salary(new BigDecimal(1100))
                .departments(new HashSet<>())
                .build();

        Department oit = Department.builder()
                .name("OIT")
                .headOfDepartment(tarasFenyk)
                .lectors(new HashSet<>())
                .build();

        tarasFenyk.getDepartments().add(oit);
        maksymMaksymiv.getDepartments().add(oit);
        bohdanBohdaniv.getDepartments().add(oit);

        oit.getLectors().add(tarasFenyk);
        oit.getLectors().add(maksymMaksymiv);
        oit.getLectors().add(bohdanBohdaniv);

        departmentRepository.save(oit);
    }

}
