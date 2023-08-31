package com.example.payements;

import com.example.payements.entities.payement;
import com.example.payements.reposities.payementRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PayementsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayementsApplication.class, args);
    }
    @Bean
    CommandLineRunner start(payementRepositories payementrepositories){
        return args -> {
            payementrepositories.save(new payement(null,new Date(),1,"Diop","Modou",7300));
            payementrepositories.findAll().forEach(cp->{
                System.out.println(cp.getNom());
                System.out.println(cp.getPrenom());
            });
        };
}
}