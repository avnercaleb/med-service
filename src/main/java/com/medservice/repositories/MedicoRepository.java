package com.medservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medservice.models.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long>{

}
