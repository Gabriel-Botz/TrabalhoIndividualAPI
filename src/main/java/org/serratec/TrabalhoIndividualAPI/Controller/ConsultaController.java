package org.serratec.TrabalhoIndividualAPI.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.serratec.TrabalhoIndividualAPI.DTO.ConsultaRequestDTO;
import org.serratec.TrabalhoIndividualAPI.DTO.ConsultaResponseDTO;
import org.serratec.TrabalhoIndividualAPI.Service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;


    @Operation(summary = "Listar consultas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Lista não encontrada")
    })
    @GetMapping
    public ResponseEntity<List<ConsultaResponseDTO>> listarTodas() {
        List<ConsultaResponseDTO> consultas = consultaService.obterTodasConsultas();
        return ResponseEntity.ok(consultas);
    }

    @Operation(summary = "Buscar consulta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Não encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ConsultaResponseDTO> buscarPorId(@PathVariable Long id) {
        try {
            ConsultaResponseDTO consulta = consultaService.obterConsultaPorId(id);
            return ResponseEntity.ok(consulta);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Cadastrar consulta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Consulta cadastrado"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping
    public ResponseEntity<ConsultaResponseDTO> criar(@RequestBody @Valid ConsultaRequestDTO dto) {
        ConsultaResponseDTO consulta = consultaService.criarConsulta(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(consulta);
    }

    @Operation(summary = "Atualizar cadastro da consulta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Consulta atualizado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ConsultaResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid ConsultaRequestDTO dto) {
        try {
            ConsultaResponseDTO consulta = consultaService.atualizar(id, dto);
            return ResponseEntity.ok(consulta);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Deletar consulta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Consulta não encontrada"),
            @ApiResponse(responseCode = "204", description = "Consulta deletada com sucesso!")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            consultaService.deletarConsulta(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

