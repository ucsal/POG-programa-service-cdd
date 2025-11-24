package com.example.disciplina_microservice.controller.dto.request;

import java.util.List;

public record ProgramaDTO(
        Long disciplinaId,
        Long matrizId,
        String ementa,
        String objetivos,
        List<String> conteudoProgramatico,
        String metodologia,
        String sistemaAvaliacao,
        boolean ativo
) {}
