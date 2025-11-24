package com.example.disciplina_microservice.model.service;

import com.ted.controledisciplinas.controller.dto.request.ProgramaDTO;
import com.ted.controledisciplinas.controller.dto.send.ProgramaResponseDTO;
import com.ted.controledisciplinas.model.entity.Disciplina;
import com.ted.controledisciplinas.model.entity.Matriz;
import com.ted.controledisciplinas.model.entity.Programa;
import com.ted.controledisciplinas.model.repository.DisciplinaRepository;
import com.ted.controledisciplinas.model.repository.MatrizRepository;
import com.ted.controledisciplinas.model.repository.ProgramaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProgramaService {

    private final ProgramaRepository programaRepository;
    private final DisciplinaRepository disciplinaRepository;
    private final MatrizRepository matrizRepository;

    public ProgramaService(ProgramaRepository programaRepository,
                           DisciplinaRepository disciplinaRepository,
                           MatrizRepository matrizRepository) {
        this.programaRepository = programaRepository;
        this.disciplinaRepository = disciplinaRepository;
        this.matrizRepository = matrizRepository;
    }

    @Transactional
    public ProgramaResponseDTO criar(ProgramaDTO dto) {
        Programa programa = new Programa();

        Disciplina disciplina = disciplinaRepository.findById(dto.disciplinaId())
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));
        programa.setDisciplina(disciplina);

        if (dto.matrizId() != null) {
            Matriz matriz = matrizRepository.findById(dto.matrizId())
                    .orElseThrow(() -> new RuntimeException("Matriz não encontrada"));
            programa.setMatriz(matriz);
        }

        programa.setEmenta(dto.ementa());
        programa.setObjetivos(dto.objetivos());
        programa.setConteudoProgramatico(dto.conteudoProgramatico());
        programa.setMetodologia(dto.metodologia());
        programa.setSistemaAvaliacao(dto.sistemaAvaliacao());
        programa.setAtivo(dto.ativo());

        programaRepository.save(programa);
        return new ProgramaResponseDTO(programa);
    }

    public List<ProgramaResponseDTO> listarTodos() {
        return programaRepository.findAll().stream()
                .map(ProgramaResponseDTO::new)
                .collect(Collectors.toList());
    }

    public ProgramaResponseDTO buscarPorId(Long id) {
        Programa programa = programaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Programa não encontrado"));
        return new ProgramaResponseDTO(programa);
    }

    @Transactional
    public ProgramaResponseDTO atualizar(Long id, ProgramaDTO dto) {
        Programa programa = programaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Programa não encontrado"));

        Disciplina disciplina = disciplinaRepository.findById(dto.disciplinaId())
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));
        programa.setDisciplina(disciplina);

        if (dto.matrizId() != null) {
            Matriz matriz = matrizRepository.findById(dto.matrizId())
                    .orElseThrow(() -> new RuntimeException("Matriz não encontrada"));
            programa.setMatriz(matriz);
        }

        programa.setEmenta(dto.ementa());
        programa.setObjetivos(dto.objetivos());
        programa.setConteudoProgramatico(dto.conteudoProgramatico());
        programa.setMetodologia(dto.metodologia());
        programa.setSistemaAvaliacao(dto.sistemaAvaliacao());
        programa.setAtivo(dto.ativo());

        programaRepository.save(programa);
        return new ProgramaResponseDTO(programa);
    }

    @Transactional
    public void deletar(Long id) {
        Programa programa = programaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Programa não encontrado"));

        if (programa.getDisciplina() != null) {
            programa.getDisciplina().setPrograma(null);
        }

        programaRepository.delete(programa);
    }

}
