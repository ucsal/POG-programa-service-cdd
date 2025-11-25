package com.example.disciplina_microservice.controller;

import com.example.disciplina_microservice.controller.dto.request.ProgramaDTO;
import com.example.disciplina_microservice.controller.dto.send.ProgramaResponseDTO;
import com.example.disciplina_microservice.model.service.ProgramaService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programas")
public class ProgramaController {

    private final ProgramaService programaService;

    public ProgramaController(ProgramaService programaService) {
        this.programaService = programaService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ProgramaResponseDTO> criar(@RequestBody ProgramaDTO dto) {
        return ResponseEntity.ok(programaService.criar(dto));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<ProgramaResponseDTO>> listarTodos() {
        return ResponseEntity.ok(programaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgramaResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(programaService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgramaResponseDTO> atualizar(@PathVariable Long id, @RequestBody ProgramaDTO dto) {
        return ResponseEntity.ok(programaService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        programaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
