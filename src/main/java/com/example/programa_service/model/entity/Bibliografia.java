package com.example.programa_service.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bibliografia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<String> autores;

    private String titulo;
    private String edicao;
    private String local;
    private String editora;
    private int anoPublicacao;
    private String isbn;
    private boolean digital;

    private String urlAcesso;
    private LocalDate ultimaDataAcesso;

    private String tipo;

    @ManyToOne
    private Programa programa;

    private Integer professorId;

    public boolean isAtivo() {
        return programa != null && programa.isAtivo();
    }
}
