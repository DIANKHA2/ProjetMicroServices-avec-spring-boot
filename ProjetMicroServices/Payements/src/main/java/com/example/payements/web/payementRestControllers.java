package com.example.payements.web;

import com.example.payements.entities.patients;
import com.example.payements.entities.payement;
import com.example.payements.reposities.payementRepositories;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@RestController
public class payementRestControllers {
    private payementRepositories payementrepositories;
    private RestTemplate  restTemplate;
    public payementRestControllers(RestTemplateBuilder restTemplateBuilder, payementRepositories payementrepositories) {
        this.payementrepositories = payementrepositories;
        this.restTemplate=restTemplateBuilder.build();
    }


    @GetMapping(path ="/Payments")
    public List<payement> listepatients(){
        return payementrepositories.findAll();
    }

    @GetMapping(path = "Payments/{id}")
    public payement recupererid (@PathVariable(name = "id") Integer numpayement){
        return payementrepositories.findById(numpayement).get();
    }
    @PostMapping(path = "/Payments/{numticket}/{montant}")
    public String save (@PathVariable Integer numticket,@PathVariable int montant  ){
        patients patient=restTemplate.getForEntity("http://localhost:8080/patients/"+numticket,patients.class).getBody();

        if (patient==null)
            return "Ce numéro de ticket n'existe pas ";
        else
        {
            payement payements=new payement();
            payements.setDate(patient.getDate());
            payements.setNumticket(numticket);
            payements.setNom(patient.getNom());
            payements.setPrenom(patient.getPrenom());
            payements.setMontant(montant);
            payementrepositories.save(payements);
            return "Vous avez fait une transaction de paiement ";
        }

    }


}
