package com.example.payements.reposities;

import com.example.payements.entities.payement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface payementRepositories extends JpaRepository<payement,Integer> {
}
