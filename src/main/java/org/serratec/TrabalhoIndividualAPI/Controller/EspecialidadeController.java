package org.serratec.TrabalhoIndividualAPI.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.serratec.TrabalhoIndividualAPI.DTO.EspecialidadeRequestDTO;
import org.serratec.TrabalhoIndividualAPI.DTO.EspecialidadeResponseDTO;
import org.serratec.TrabalhoIndividualAPI.Service.EspecialidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadeController {

    @Autowired
    private EspecialidadeService especialidadeService;

    @Operation(summary = "Listar especialidades")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Lista não encontrada")
    })
    @GetMapping
    public ResponseEntity<List<EspecialidadeResponseDTO>> listarTodas() {
        List<EspecialidadeResponseDTO> especialidades = especialidadeService.listarTodasEspecialidades();
        return ResponseEntity.ok(especialidades);
    }

    @Operation(summary = "Buscar especialidade")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Especialidade não encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<EspecialidadeResponseDTO> buscarPorId(@PathVariable Long id) {
        try {
            EspecialidadeResponseDTO especialidade = especialidadeService.buscarEspecialidadePorId(id);
            return ResponseEntity.ok(especialidade);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Cadastrar especialidade")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Especialidade cadastrado"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping
    public ResponseEntity<EspecialidadeResponseDTO> criar(@RequestBody @Valid EspecialidadeRequestDTO dto) {
        EspecialidadeResponseDTO especialidade = especialidadeService.criarEspecialidade(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(especialidade);
    }

    @Operation(summary = "Atualizar cadastro de especialidade")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Especialidade atualizado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PutMapping("/{id}")
    public ResponseEntity<EspecialidadeResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid EspecialidadeRequestDTO dto) {
        try {
            EspecialidadeResponseDTO especialidade = especialidadeService.atualizarEspecialidade(id, dto);
            return ResponseEntity.ok(especialidade);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Deletar especialidade")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Especialidade não encontrado"),
            @ApiResponse(responseCode = "204", description = "Especialidade deletado com sucesso!")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            especialidadeService.deletarEspecialidade(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

