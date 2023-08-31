package com.example.consultations.web;

import com.example.consultations.Repositories.consultationRestRepositories;
import com.example.consultations.entities.Consultation;
import com.example.consultations.entities.patients;
import com.example.consultations.entities.payement;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
@RestController
public class consultationController {
    private consultationRestRepositories consultationrestrepositories;
    private RestTemplate restTemplate;

    public consultationController(RestTemplateBuilder restTemplateBuilder, consultationRestRepositories consultationrestrepositories) {
        this.consultationrestrepositories = consultationrestrepositories;
        this.restTemplate=restTemplateBuilder.build();
    }
    @GetMapping(path ="/consultations")
    public List<Consultation> listepatients(){
        return consultationrestrepositories.findAll();
    }

    @GetMapping(path = "consultations/{id}")
    public Consultation recupererid (@PathVariable(name = "id") Integer numpayement){
        return consultationrestrepositories.findById(numpayement).get();
    }
    @PostMapping(path = "/consultations/{numticket}/{numpayement}")
    public String save (@PathVariable Integer numticket, @PathVariable Integer numpayement){
        patients patient=restTemplate.getForEntity("http://localhost:8080/patients/"+numticket,patients.class).getBody();
        payement payements =restTemplate.getForEntity("http://localhost:8081/Payments/"+numpayement,payement.class).getBody();
        if (payements==null && patient==null )
            return "Ce numéro de ticket n'existe pas ";
        else
        {
            Consultation consultation=new Consultation();
            consultation.setNumticket(numticket);
            consultation.setDate(payements.getDate());
            consultation.setNom(patient.getNom());
            consultation.setPrenom(patient.getPrenom());
            consultation.setAge(patient.getAge());
            consultation.setMontant(payements.getMontant());
            consultationrestrepositories.save(consultation);
            return "Vous avez fait une transaction de consultation ";
        }

    }

}
