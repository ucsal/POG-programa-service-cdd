package com.example.programa_service.model.service;

import com.example.programa_service.controller.dto.request.BibliografiaRequestDTO;
import com.example.programa_service.controller.dto.send.BibliografiaSendDTO;
import com.example.programa_service.model.entity.Bibliografia;
import com.example.programa_service.model.entity.Programa;
import com.example.programa_service.model.repository.BibliografiaRepository;
import com.example.programa_service.model.repository.ProgramaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliografiaService {

    @Autowired
    private BibliografiaRepository bibliografiaRepository;

    @Autowired
    private ProgramaRepository programaRepository;

    public BibliografiaSendDTO criar(BibliografiaRequestDTO dto) {
        Programa programa = programaRepository.findById(dto.programaId())
                .orElseThrow(() -> new RuntimeException("Programa não encontrado"));

        Bibliografia b = new Bibliografia();
        b.setAutores(dto.autores());
        b.setTitulo(dto.titulo());
        b.setEdicao(dto.edicao());
        b.setLocal(dto.local());
        b.setEditora(dto.editora());
        b.setAnoPublicacao(dto.anoPublicacao());
        b.setIsbn(dto.isbn());
        b.setDigital(dto.digital());
        b.setUrlAcesso(dto.urlAcesso());
        b.setUltimaDataAcesso(dto.ultimaDataAcesso());
        b.setTipo(dto.tipo());
        b.setPrograma(programa);

        bibliografiaRepository.save(b);

        return toSendDTO(b);
    }

    public List<BibliografiaSendDTO> listar() {
        return bibliografiaRepository.findAll().stream()
                .map(this::toSendDTO)
                .toList();
    }

    public BibliografiaSendDTO buscarPorId(Long id) {
        Bibliografia b = bibliografiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bibliografia não encontrada"));
        return toSendDTO(b);
    }

    public BibliografiaSendDTO atualizar(Long id, BibliografiaRequestDTO dto) {
        Bibliografia b = bibliografiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bibliografia não encontrada"));

        b.setAutores(dto.autores());
        b.setTitulo(dto.titulo());
        b.setEdicao(dto.edicao());
        b.setLocal(dto.local());
        b.setEditora(dto.editora());
        b.setAnoPublicacao(dto.anoPublicacao());
        b.setIsbn(dto.isbn());
        b.setDigital(dto.digital());
        b.setUrlAcesso(dto.urlAcesso());
        b.setUltimaDataAcesso(dto.ultimaDataAcesso());
        b.setTipo(dto.tipo());

        bibliografiaRepository.save(b);
        return toSendDTO(b);
    }

    public void deletar(Long id) {
        bibliografiaRepository.deleteById(id);
    }

    private BibliografiaSendDTO toSendDTO(Bibliografia b) {
        return new BibliografiaSendDTO(
                b.getId(),
                b.getAutores(),
                b.getTitulo(),
                b.getEdicao(),
                b.getLocal(),
                b.getEditora(),
                b.getAnoPublicacao(),
                b.getIsbn(),
                b.isDigital(),
                b.getUrlAcesso(),
                b.getUltimaDataAcesso(),
                b.getTipo(),
                b.isAtivo()
        );
    }
}
