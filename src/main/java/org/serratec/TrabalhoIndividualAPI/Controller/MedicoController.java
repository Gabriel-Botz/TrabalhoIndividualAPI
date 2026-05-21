package org.serratec.TrabalhoIndividualAPI.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.serratec.TrabalhoIndividualAPI.DTO.MedicoRequestDTO;
import org.serratec.TrabalhoIndividualAPI.DTO.MedicoResponseDTO;
import org.serratec.TrabalhoIndividualAPI.Service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @Operation(summary = "Listar médicos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Lista não encontrada")
    })
    @GetMapping
    public ResponseEntity<List<MedicoResponseDTO>> listarTodos() {
        List<MedicoResponseDTO> medicos = medicoService.obterTodosMedicos();
        return ResponseEntity.ok(medicos);
    }

    @Operation(summary = "Buscar médicos")
    @ApiResponses(value = {
             @ApiResponse(responseCode = "400", description = "Médico não encontrado")    })
    @GetMapping("/{id}")
    public ResponseEntity<MedicoResponseDTO> buscarPorId(@PathVariable Long id) {
        try {
            MedicoResponseDTO medico = medicoService.obterMedicoPorId(id);
            return ResponseEntity.ok(medico);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Cadastrar médico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Médico cadastrado"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping
    public ResponseEntity<MedicoResponseDTO> criar(@RequestBody @Valid MedicoRequestDTO dto) {
        MedicoResponseDTO medico = medicoService.criarMedico(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(medico);
    }

    @Operation(summary = "Atualizar cadastro de médico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Médico atualizado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PutMapping("/{id}")
    public ResponseEntity<MedicoResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid MedicoRequestDTO dto) {
        try {
            MedicoResponseDTO medico = medicoService.atualizar(id, dto);
            return ResponseEntity.ok(medico);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Deletar médico")
    @ApiResponses(value = {
              @ApiResponse(responseCode = "400", description = "Médico não encontrado"),
            @ApiResponse(responseCode = "204", description = "Médico deletado com sucesso!")   })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            medicoService.deletarMedico(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

