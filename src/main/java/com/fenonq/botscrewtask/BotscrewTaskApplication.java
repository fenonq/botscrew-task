package com.fenonq.botscrewtask;

import com.fenonq.botscrewtask.util.DataLoader;
import com.fenonq.botscrewtask.util.UserInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class BotscrewTaskApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BotscrewTaskApplication.class, args);
    }

    private final UserInterface userInterface;
    private final DataLoader dataLoader;

    @Override
    public void run(String... args) {
        dataLoader.loadData();
        userInterface.menu();
    }

}
