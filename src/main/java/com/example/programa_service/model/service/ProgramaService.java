package com.example.programa_service.model.service;

import com.example.programa_service.controller.dto.request.ProgramaDTO;
import com.example.programa_service.controller.dto.send.ProgramaResponseDTO;
import com.example.programa_service.model.entity.Programa;
import com.example.programa_service.model.repository.ProgramaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProgramaService {

    private final ProgramaRepository programaRepository;

    public ProgramaService(ProgramaRepository programaRepository) {
        this.programaRepository = programaRepository;
    }

    @Transactional
    public ProgramaResponseDTO criar(ProgramaDTO dto) {
        Programa programa = new Programa();
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
                .map(programa -> new ProgramaResponseDTO(programa))
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
        programaRepository.delete(programa);
    }

}
