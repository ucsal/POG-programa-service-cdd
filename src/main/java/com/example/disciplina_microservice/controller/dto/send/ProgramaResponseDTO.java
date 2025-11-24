package com.example.disciplina_microservice.controller.dto.send;

import com.ted.controledisciplinas.model.entity.Programa;

import java.util.List;

public record ProgramaResponseDTO(
        Long id,
        Long disciplinaId,
        Long matrizId,
        String ementa,
        String objetivos,
        List<String> conteudoProgramatico,
        String metodologia,
        String sistemaAvaliacao,
        boolean ativo
) {
    public ProgramaResponseDTO(Programa programa) {
        this(
                programa.getId(),
                programa.getDisciplina() != null ? programa.getDisciplina().getId() : null,
                programa.getMatriz() != null ? programa.getMatriz().getId() : null,
                programa.getEmenta(),
                programa.getObjetivos(),
                programa.getConteudoProgramatico(),
                programa.getMetodologia(),
                programa.getSistemaAvaliacao(),
                programa.isAtivo()
        );
    }
}
