package com.fenonq.botscrewtask.util;

import com.fenonq.botscrewtask.exception.EntityNotFoundException;
import com.fenonq.botscrewtask.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class UserInterface {

    private final UniversityService universityService;

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        short action;
        while (true) {
            action = commandInput(scanner);
            try {
                switch (action) {
                    case 1 -> {
                        String departmentName = userInput(scanner, "Enter department name: ");
                        System.out.printf("\nWho is head of department %s?\n", departmentName);
                        System.out.println(universityService.showHeadOfDepartmentByName(departmentName));
                    }
                    case 2 -> {
                        String departmentName = userInput(scanner, "Enter department name: ");
                        System.out.printf("\nShow %s statistics.\n", departmentName);
                        System.out.println(universityService.showStatisticsByDepartmentName(departmentName));
                    }
                    case 3 -> {
                        String departmentName = userInput(scanner, "Enter department name: ");
                        System.out.printf("\nShow the average salary for the department %s.\n", departmentName);
                        System.out.println(universityService.showAvgSalaryByDepartmentName(departmentName));
                    }
                    case 4 -> {
                        String departmentName = userInput(scanner, "Enter department name: ");
                        System.out.printf("\nShow count of employee for %s.\n", departmentName);
                        System.out.println(universityService.showEmployeeCountByDepartmentName(departmentName));
                    }
                    case 5 -> {
                        String template = userInput(scanner, "Enter template: ");
                        System.out.printf("\nGlobal search by %s.\n", template);
                        System.out.println(universityService.globalSearch(template));
                    }
                    case 0 -> {
                        System.out.println("\nExit...");
                        System.exit(0);
                    }
                    default -> System.out.println("\nNo such command!");
                }
            } catch (EntityNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private short commandInput(Scanner scanner) {
        System.out.println("\nChoose command:\n" +
                "1 - Who is head of department\n" +
                "2 - Show department statistics\n" +
                "3 - Show average salary for department\n" +
                "4 - Show count of employee for department\n" +
                "5 - Global search by template\n" +
                "0 - Exit\n");
        return validateInput(scanner.next());
    }

    private short validateInput(String input) {
        try {
            return Short.parseShort(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private String userInput(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.next();
    }

}
