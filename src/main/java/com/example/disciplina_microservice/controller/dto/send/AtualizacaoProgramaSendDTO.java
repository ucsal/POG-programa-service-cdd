package com.example.disciplina_microservice.controller.dto.send;

import java.time.LocalDateTime;

public record AtualizacaoProgramaSendDTO(
        Long id,
        Long programaId,
        Long professorId,
        String descricaoAtualizacao,
        LocalDateTime dataFinalizacao
) {}
