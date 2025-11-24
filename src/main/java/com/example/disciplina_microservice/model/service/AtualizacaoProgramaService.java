package com.example.disciplina_microservice.model.service;

import com.example.disciplina_microservice.controller.dto.request.AtualizacaoProgramaRequestDTO;
import com.example.disciplina_microservice.controller.dto.send.AtualizacaoProgramaSendDTO;
import com.example.disciplina_microservice.model.entity.AtualizacaoPrograma;
import com.example.disciplina_microservice.model.entity.Programa;
import com.example.disciplina_microservice.model.repository.AtualizacaoProgramaRepository;
import com.example.disciplina_microservice.model.repository.ProgramaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtualizacaoProgramaService {

    @Autowired
    private AtualizacaoProgramaRepository repository;

    @Autowired
    private ProgramaRepository programaRepository;

    public AtualizacaoProgramaSendDTO criar(AtualizacaoProgramaRequestDTO dto) {
        Programa programa = programaRepository.findById(dto.programaId())
                .orElseThrow(() -> new RuntimeException("Programa não encontrado"));

        AtualizacaoPrograma atualizacao = new AtualizacaoPrograma();
        atualizacao.setPrograma(programa);
        atualizacao.setDescricaoAtualizacao(dto.descricaoAtualizacao());
        atualizacao.setDataFinalizacao(dto.dataFinalizacao());

        repository.save(atualizacao);

        return toSendDTO(atualizacao);
    }

    public List<AtualizacaoProgramaSendDTO> listar() {
        return repository.findAll().stream()
                .map(this::toSendDTO)
                .toList();
    }

    public AtualizacaoProgramaSendDTO buscarPorId(Long id) {
        AtualizacaoPrograma atualizacao = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Atualizacao não encontrada"));
        return toSendDTO(atualizacao);
    }

    public AtualizacaoProgramaSendDTO atualizar(Long id, AtualizacaoProgramaRequestDTO dto) {
        AtualizacaoPrograma atualizacao = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Atualizacao não encontrada"));

        if (dto.programaId() != null) {
            Programa programa = programaRepository.findById(dto.programaId())
                    .orElseThrow(() -> new RuntimeException("Programa não encontrado"));
            atualizacao.setPrograma(programa);
        }

        atualizacao.setDescricaoAtualizacao(dto.descricaoAtualizacao());
        atualizacao.setDataFinalizacao(dto.dataFinalizacao());

        repository.save(atualizacao);
        return toSendDTO(atualizacao);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    private AtualizacaoProgramaSendDTO toSendDTO(AtualizacaoPrograma atualizacao) {
        return new AtualizacaoProgramaSendDTO(
                atualizacao.getId(),
                atualizacao.getPrograma() != null ? atualizacao.getPrograma().getId() : null,
                atualizacao.getProfessor() != null ? atualizacao.getProfessor().getId() : null,
                atualizacao.getDescricaoAtualizacao(),
                atualizacao.getDataFinalizacao()
        );
    }
}
