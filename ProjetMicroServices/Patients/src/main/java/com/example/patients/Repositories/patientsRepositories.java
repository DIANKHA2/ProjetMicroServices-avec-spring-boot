package com.example.patients.Repositories;

import com.example.patients.entities.patients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface patientsRepositories extends JpaRepository<patients,Integer> {
}
