package com.example.disciplina_microservice.controller.dto.request;

import java.time.LocalDateTime;

public record AtualizacaoProgramaRequestDTO(
        Long programaId,
        Long professorId,
        String descricaoAtualizacao,
        LocalDateTime dataFinalizacao
) {}
