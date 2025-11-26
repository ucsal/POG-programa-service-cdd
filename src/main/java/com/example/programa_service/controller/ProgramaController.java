package com.example.programa_service.controller;

import com.example.programa_service.controller.dto.request.ProgramaDTO;
import com.example.programa_service.controller.dto.send.ProgramaResponseDTO;
import com.example.programa_service.model.service.ProgramaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programas")
public class ProgramaController {

    private final ProgramaService programaService;

    public ProgramaController(ProgramaService programaService) {
        this.programaService = programaService;
    }

    @PostMapping
    public ResponseEntity<ProgramaResponseDTO> criar(@RequestBody ProgramaDTO dto) {
        return ResponseEntity.ok(programaService.criar(dto));
    }

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
