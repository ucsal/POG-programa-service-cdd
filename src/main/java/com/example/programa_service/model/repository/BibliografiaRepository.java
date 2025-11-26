package com.example.programa_service.model.repository;

import com.example.programa_service.model.entity.Bibliografia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliografiaRepository extends JpaRepository<Bibliografia, Long> {
}
