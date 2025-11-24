package com.example.disciplina_microservice.model.repository;

import com.example.disciplina_microservice.model.entity.AtualizacaoPrograma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtualizacaoProgramaRepository extends JpaRepository<AtualizacaoPrograma, Long> {
}
