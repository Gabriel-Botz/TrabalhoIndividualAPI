package org.serratec.TrabalhoIndividualAPI.Controller;

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

    @GetMapping
    public ResponseEntity<List<ConsultaResponseDTO>> listarTodas() {
        List<ConsultaResponseDTO> consultas = consultaService.obterTodasConsultas();
        return ResponseEntity.ok(consultas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaResponseDTO> buscarPorId(@PathVariable Long id) {
        try {
            ConsultaResponseDTO consulta = consultaService.obterConsultaPorId(id);
            return ResponseEntity.ok(consulta);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ConsultaResponseDTO> criar(@RequestBody @Valid ConsultaRequestDTO dto) {
        ConsultaResponseDTO consulta = consultaService.criarConsulta(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(consulta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultaResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid ConsultaRequestDTO dto) {
        try {
            ConsultaResponseDTO consulta = consultaService.atualizar(id, dto);
            return ResponseEntity.ok(consulta);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

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

