package com.example.consultations.Repositories;

import com.example.consultations.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface consultationRestRepositories extends JpaRepository<Consultation ,Integer> {
}
