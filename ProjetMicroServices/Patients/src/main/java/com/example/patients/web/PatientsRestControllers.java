package com.example.patients.web;
import com.example.patients.Repositories.patientsRepositories;
import com.example.patients.entities.patients;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class PatientsRestControllers {
    private patientsRepositories patientsrepositories;


    public PatientsRestControllers(patientsRepositories patientsrepositories) {
        this.patientsrepositories = patientsrepositories;
    }
    @GetMapping(path ="/patients")
    public List<patients> listepatients(){
        return patientsrepositories.findAll();
    }
    @GetMapping(path = "patients/{id}")
    public patients recupererid (@PathVariable(name = "id") Integer  numtickets){
        return patientsrepositories.findById( numtickets).get();
    }
    @PostMapping(path = "/patients")
    public patients save (@RequestBody patients Patients ){
        return patientsrepositories.save(Patients);
    }


}
