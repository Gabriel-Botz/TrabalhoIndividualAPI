package org.serratec.TrabalhoIndividualAPI.Controller;

import org.serratec.TrabalhoIndividualAPI.DTO.ProntuarioRequestDTO;
import org.serratec.TrabalhoIndividualAPI.DTO.ProntuarioResponseDTO;
import org.serratec.TrabalhoIndividualAPI.Service.ProntuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/prontuarios")
public class ProntuarioController {

    @Autowired
    private ProntuarioService prontuarioService;

    @GetMapping
    public ResponseEntity<List<ProntuarioResponseDTO>> listarTodos() {
        List<ProntuarioResponseDTO> prontuarios = prontuarioService.listarTodosProntuarios();
        return ResponseEntity.ok(prontuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProntuarioResponseDTO> buscarPorId(@PathVariable Long id) {
        try {
            ProntuarioResponseDTO prontuario = prontuarioService.buscarPorId(id);
            return ResponseEntity.ok(prontuario);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<ProntuarioResponseDTO>> listarPorPaciente(@PathVariable Long pacienteId) {
        try {
            List<ProntuarioResponseDTO> prontuarios = prontuarioService.listarProntuariosPorPacienteId(pacienteId);
            return ResponseEntity.ok(prontuarios);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ProntuarioResponseDTO> criar(@RequestBody @Valid ProntuarioRequestDTO dto) {
        try {
            ProntuarioResponseDTO prontuario = prontuarioService.criarProntuario(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(prontuario);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProntuarioResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid ProntuarioRequestDTO dto) {
        try {
            ProntuarioResponseDTO prontuario = prontuarioService.atualizarProntuario(id, dto);
            return ResponseEntity.ok(prontuario);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            prontuarioService.deletarProntuario(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

