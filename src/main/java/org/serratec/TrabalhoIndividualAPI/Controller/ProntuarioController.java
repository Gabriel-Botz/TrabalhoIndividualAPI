package org.serratec.TrabalhoIndividualAPI.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Listar prontuários")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Lista não encontrada")
    })
    @GetMapping
    public ResponseEntity<List<ProntuarioResponseDTO>> listarTodos() {
        List<ProntuarioResponseDTO> prontuarios = prontuarioService.listarTodosProntuarios();
        return ResponseEntity.ok(prontuarios);
    }

    @Operation(summary = "Buscar prontuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Prontuário não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProntuarioResponseDTO> buscarPorId(@PathVariable Long id) {
        try {
            ProntuarioResponseDTO prontuario = prontuarioService.buscarPorId(id);
            return ResponseEntity.ok(prontuario);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Buscar prontuário por paciente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Não encontrado")
    })
    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<ProntuarioResponseDTO>> listarPorPaciente(@PathVariable Long pacienteId) {
        try {
            List<ProntuarioResponseDTO> prontuarios = prontuarioService.listarProntuariosPorPacienteId(pacienteId);
            return ResponseEntity.ok(prontuarios);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Cadastrar prontuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Prontuário cadastrado"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping
    public ResponseEntity<ProntuarioResponseDTO> criar(@RequestBody @Valid ProntuarioRequestDTO dto) {
        try {
            ProntuarioResponseDTO prontuario = prontuarioService.criarProntuario(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(prontuario);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Atualizar cadastro de prontuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Prontuário atualizado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ProntuarioResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid ProntuarioRequestDTO dto) {
        try {
            ProntuarioResponseDTO prontuario = prontuarioService.atualizarProntuario(id, dto);
            return ResponseEntity.ok(prontuario);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Deletar prontuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Prontuário não encontrado"),
            @ApiResponse(responseCode = "204", description = "Prontuário deletado com sucesso!")
    })
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

