package com.example.disciplina_microservice.controller.dto.send;

import com.example.disciplina_microservice.model.entity.Programa;

import java.util.List;

public record ProgramaResponseDTO(
        Long id,
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
                programa.getEmenta(),
                programa.getObjetivos(),
                programa.getConteudoProgramatico(),
                programa.getMetodologia(),
                programa.getSistemaAvaliacao(),
                programa.isAtivo()
        );
    }
}
