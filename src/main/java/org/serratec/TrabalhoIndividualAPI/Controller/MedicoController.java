package org.serratec.TrabalhoIndividualAPI.Controller;

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

    @GetMapping
    public ResponseEntity<List<MedicoResponseDTO>> listarTodos() {
        List<MedicoResponseDTO> medicos = medicoService.obterTodosMedicos();
        return ResponseEntity.ok(medicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoResponseDTO> buscarPorId(@PathVariable Long id) {
        try {
            MedicoResponseDTO medico = medicoService.obterMedicoPorId(id);
            return ResponseEntity.ok(medico);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<MedicoResponseDTO> criar(@RequestBody @Valid MedicoRequestDTO dto) {
        MedicoResponseDTO medico = medicoService.criarMedico(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(medico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicoResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid MedicoRequestDTO dto) {
        try {
            MedicoResponseDTO medico = medicoService.atualizar(id, dto);
            return ResponseEntity.ok(medico);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

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

