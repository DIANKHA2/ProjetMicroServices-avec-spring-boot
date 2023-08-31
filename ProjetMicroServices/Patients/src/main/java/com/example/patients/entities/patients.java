package com.example.patients.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class patients {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  numtickets;
    private  String nom;
    private  String prenom;
    private Date date;
    private int age;
    private  int poids;
    private int temperature;
}
