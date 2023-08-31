package com.example.payements.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class payement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  numpayement;
    private Date date;
    private int numticket;
    private  String nom;
    private  String prenom;
    private int montant;
}
