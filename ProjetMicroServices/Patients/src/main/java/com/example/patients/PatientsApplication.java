package com.example.patients;

import com.example.patients.Repositories.patientsRepositories;
import com.example.patients.entities.patients;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsApplication.class, args);
    }
     @Bean
    CommandLineRunner start(patientsRepositories patientsrepositories){
        return args -> {
          patientsrepositories.save(new patients(null,"Diop","Modou",new Date(),18,73,37));
          patientsrepositories.findAll().forEach(cp->{
               System.out.println(cp.getNom());
              System.out.println(cp.getPrenom());
          });
        };
     }
}
