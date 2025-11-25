package com.example.disciplina_microservice.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Programa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Integer matriz;

    @OneToOne
    private Integer disciplina;

    private String ementa;
    private String objetivos;
    private String metodologia;
    private String sistemaAvaliacao;

    @ElementCollection
    private List<String> conteudoProgramatico;

    private boolean ativo = true;

    @OneToMany(mappedBy = "programa")
    private List<Bibliografia> bibliografias;

    @OneToMany(mappedBy = "programa")
    private List<AtualizacaoPrograma> historicoAtualizacoes;
}

