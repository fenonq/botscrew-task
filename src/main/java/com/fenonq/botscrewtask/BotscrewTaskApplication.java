package com.fenonq.botscrewtask;

import com.fenonq.botscrewtask.model.enums.Degree;
import com.fenonq.botscrewtask.model.Department;
import com.fenonq.botscrewtask.model.Lector;
import com.fenonq.botscrewtask.repository.DepartmentRepository;
import com.fenonq.botscrewtask.repository.LectorRepository;
import com.fenonq.botscrewtask.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.HashSet;

@SpringBootApplication
@RequiredArgsConstructor
public class BotscrewTaskApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BotscrewTaskApplication.class, args);
    }

    private final DepartmentRepository departmentRepository;
    private final LectorRepository lectorRepository;
    private final UniversityService universityService;

    @Override
    public void run(String... args) {

        System.out.println(universityService.showHeadOfDepartmentByName("AMI"));
        System.out.println(universityService.showStatisticsByDepartmentName("AMI"));
        System.out.println(universityService.showAvgSalaryByDepartmentName("AMI"));
        System.out.println(universityService.showEmployeeCountByDepartmentName("AMI"));
        System.out.println(universityService.globalSearch("2"));

//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
//        System.out.println(str);

//        Lector lector = Lector.builder()
//                .name("Taras")
//                .surname("NeTaras")
//                .degree(Degree.PROFESSOR)
//                .salary(new BigDecimal(111))
//                .departments(new HashSet<>())
//                .build();
//
//        Lector lector1 = Lector.builder()
//                .name("Taras1")
//                .surname("NeTaras1")
//                .degree(Degree.PROFESSOR)
//                .salary(new BigDecimal(222))
//                .departments(new HashSet<>())
//                .build();
//
//        Lector lector2 = Lector.builder()
//                .name("Taras2")
//                .surname("NeTaras2")
//                .degree(Degree.ASSISTANT)
//                .salary(new BigDecimal(333))
//                .departments(new HashSet<>())
//                .build();
//
//        Department department = Department.builder()
//                .name("AMI")
//                .headOfDepartment(lector)
//                .lectors(new HashSet<>())
//                .build();
//
//        lector.getDepartments().add(department);
//        lector1.getDepartments().add(department);
//        lector2.getDepartments().add(department);
//
//        department.getLectors().add(lector);
//        department.getLectors().add(lector1);
//        department.getLectors().add(lector2);
//
//        departmentRepository.save(department);
    }
}
