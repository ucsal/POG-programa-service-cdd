package com.example.programa_service.controller.dto.send;

import java.time.LocalDateTime;

public record AtualizacaoProgramaSendDTO(
        Long id,
        Long programaId,
        Integer professorId,
        String descricaoAtualizacao,
        LocalDateTime dataFinalizacao
) {}
