package com.example.programa_service.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtualizacaoPrograma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer professorId;

    @ManyToOne
    @JoinColumn(name = "programa_id", nullable = false)
    private Programa programa;

    private String descricaoAtualizacao;
    private LocalDateTime dataFinalizacao;
}
