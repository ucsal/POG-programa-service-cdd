package com.example.disciplina_microservice.controller;

import com.ted.controledisciplinas.controller.dto.request.AtualizacaoProgramaRequestDTO;
import com.ted.controledisciplinas.controller.dto.send.AtualizacaoProgramaSendDTO;
import com.ted.controledisciplinas.model.service.AtualizacaoProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/atualizacoes")
public class AtualizacaoProgramaController {

    @Autowired
    private AtualizacaoProgramaService service;

    @PostMapping
    public ResponseEntity<AtualizacaoProgramaSendDTO> criar(@RequestBody AtualizacaoProgramaRequestDTO dto) {
        return ResponseEntity.ok(service.criar(dto));
    }

    @GetMapping
    public ResponseEntity<List<AtualizacaoProgramaSendDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtualizacaoProgramaSendDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtualizacaoProgramaSendDTO> atualizar(@PathVariable Long id, @RequestBody AtualizacaoProgramaRequestDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/programa/{idSistema}")
    public ResponseEntity<List<AtualizacaoProgramaSendDTO>> buscarPorPrograma(@PathVariable Long idSistema){
        Stream<AtualizacaoProgramaSendDTO> atualizacaoProgramaSendDTOStream = service.listar().stream().filter(a -> idSistema == a.programaId());
        return (ResponseEntity<List<AtualizacaoProgramaSendDTO>>) atualizacaoProgramaSendDTOStream;
    }
}
