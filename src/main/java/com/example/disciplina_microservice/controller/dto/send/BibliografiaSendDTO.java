package com.example.disciplina_microservice.controller.dto.send;

import java.time.LocalDate;
import java.util.List;

public record BibliografiaSendDTO(
        Long id,
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
        boolean ativo
) {}
