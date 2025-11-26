package com.example.programa_service.model.service;

import com.example.programa_service.controller.dto.request.AtualizacaoProgramaRequestDTO;
import com.example.programa_service.controller.dto.send.AtualizacaoProgramaSendDTO;
import com.example.programa_service.model.entity.AtualizacaoPrograma;
import com.example.programa_service.model.entity.Programa;
import com.example.programa_service.model.repository.AtualizacaoProgramaRepository;
import com.example.programa_service.model.repository.ProgramaRepository;
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
                atualizacao.getProfessorId(),
                atualizacao.getDescricaoAtualizacao(),
                atualizacao.getDataFinalizacao()
        );
    }
}
