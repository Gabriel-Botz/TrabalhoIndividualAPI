package org.serratec.TrabalhoIndividualAPI.Controller;

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

    @GetMapping
    public ResponseEntity<List<EspecialidadeResponseDTO>> listarTodas() {
        List<EspecialidadeResponseDTO> especialidades = especialidadeService.listarTodasEspecialidades();
        return ResponseEntity.ok(especialidades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EspecialidadeResponseDTO> buscarPorId(@PathVariable Long id) {
        try {
            EspecialidadeResponseDTO especialidade = especialidadeService.buscarEspecialidadePorId(id);
            return ResponseEntity.ok(especialidade);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<EspecialidadeResponseDTO> criar(@RequestBody @Valid EspecialidadeRequestDTO dto) {
        EspecialidadeResponseDTO especialidade = especialidadeService.criarEspecialidade(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(especialidade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EspecialidadeResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid EspecialidadeRequestDTO dto) {
        try {
            EspecialidadeResponseDTO especialidade = especialidadeService.atualizarEspecialidade(id, dto);
            return ResponseEntity.ok(especialidade);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

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

