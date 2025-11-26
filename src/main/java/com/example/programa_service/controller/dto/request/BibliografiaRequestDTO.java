package com.example.programa_service.controller.dto.request;

import java.time.LocalDate;
import java.util.List;

public record BibliografiaRequestDTO(
        List<String> autores,
        String titulo,
        String edicao,
        String local,
        String editora,
        int anoPublicacao,
        String isbn,
        boolean digital,
        String urlAcesso,
        LocalDate ultimaDataAcesso,
        String tipo,
        Long programaId,
        Long professorId
) {}
