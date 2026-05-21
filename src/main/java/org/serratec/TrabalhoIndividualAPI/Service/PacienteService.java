package org.serratec.TrabalhoIndividualAPI.Service;

import org.serratec.TrabalhoIndividualAPI.DTO.PacienteRequestDTO;
import org.serratec.TrabalhoIndividualAPI.DTO.PacienteResponseDTO;
import org.serratec.TrabalhoIndividualAPI.Domain.Paciente;
import org.serratec.TrabalhoIndividualAPI.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<PacienteResponseDTO> listarTodos(){
        List<Paciente> pacientes = pacienteRepository.findAll();
        List<PacienteResponseDTO> response = new ArrayList<>();

        for (Paciente paciente : pacientes){
            PacienteResponseDTO dto = new PacienteResponseDTO(
                    paciente.getId(),
                    paciente.getNome(),
                    paciente.getEmail(),
                    paciente.getTelefone()
            );
            response.add(dto);
        }
        return response;
    }

    public PacienteResponseDTO buscarPorId(Long id){
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        return new PacienteResponseDTO(
                paciente.getId(),
                paciente.getNome(),
                paciente.getEmail(),
                paciente.getTelefone()
        );
    }

    public PacienteResponseDTO criarPaciente(PacienteRequestDTO dto){
        Paciente novoPaciente = new Paciente();
        novoPaciente.setCpf(dto.getCpf());
        novoPaciente.setDataNascimento(dto.getDataNascimento());
        novoPaciente.setNome(dto.getNome());
        novoPaciente.setEmail(dto.getEmail());
        novoPaciente.setTelefone(dto.getTelefone());

        Paciente pacienteSalvo = pacienteRepository.save(novoPaciente);

        return new PacienteResponseDTO(
                pacienteSalvo.getId(),
                pacienteSalvo.getNome(),
                pacienteSalvo.getEmail(),
                pacienteSalvo.getTelefone()
        );
    }

    public PacienteResponseDTO atualizar(Long id, PacienteRequestDTO dto){
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        paciente.setCpf(dto.getCpf());
        paciente.setDataNascimento(dto.getDataNascimento());
        paciente.setNome(dto.getNome());
        paciente.setEmail(dto.getEmail());
        paciente.setTelefone(dto.getTelefone());

        Paciente pacienteAtualizado = pacienteRepository.save(paciente);

        return new PacienteResponseDTO(
                pacienteAtualizado.getId(),
                pacienteAtualizado.getNome(),
                pacienteAtualizado.getEmail(),
                pacienteAtualizado.getTelefone()
        );
    }

    public void deletar(Long id){
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        pacienteRepository.delete(paciente);

    }







}
