package com.example.disciplina_microservice.model.repository;

import com.example.disciplina_microservice.model.entity.Bibliografia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliografiaRepository extends JpaRepository<Bibliografia, Long> {
}
