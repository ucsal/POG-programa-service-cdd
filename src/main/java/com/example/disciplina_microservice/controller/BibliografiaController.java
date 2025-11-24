package com.example.disciplina_microservice.controller;

import com.example.disciplina_microservice.controller.dto.request.BibliografiaRequestDTO;
import com.example.disciplina_microservice.controller.dto.send.BibliografiaSendDTO;
import com.example.disciplina_microservice.model.service.BibliografiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bibliografias")
public class BibliografiaController {

    @Autowired
    private BibliografiaService bibliografiaService;

    @PostMapping
    public ResponseEntity<BibliografiaSendDTO> criar(@RequestBody BibliografiaRequestDTO dto) {
        return ResponseEntity.ok(bibliografiaService.criar(dto));
    }

    @GetMapping
    public ResponseEntity<List<BibliografiaSendDTO>> listar() {
        return ResponseEntity.ok(bibliografiaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BibliografiaSendDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(bibliografiaService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BibliografiaSendDTO> atualizar(@PathVariable Long id, @RequestBody BibliografiaRequestDTO dto) {
        return ResponseEntity.ok(bibliografiaService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        bibliografiaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
