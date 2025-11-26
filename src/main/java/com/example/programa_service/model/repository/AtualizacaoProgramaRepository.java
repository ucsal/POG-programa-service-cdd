package com.example.programa_service.model.repository;

import com.example.programa_service.model.entity.AtualizacaoPrograma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtualizacaoProgramaRepository extends JpaRepository<AtualizacaoPrograma, Long> {
}
