package org.serratec.TrabalhoIndividualAPI.Service;

import org.serratec.TrabalhoIndividualAPI.DTO.PacienteResponseDTO;
import org.serratec.TrabalhoIndividualAPI.DTO.ProntuarioRequestDTO;
import org.serratec.TrabalhoIndividualAPI.DTO.ProntuarioResponseDTO;
import org.serratec.TrabalhoIndividualAPI.Domain.Prontuario;
import org.serratec.TrabalhoIndividualAPI.Exceptions.ResourceNotFoundException;
import org.serratec.TrabalhoIndividualAPI.Repository.PacienteRepository;
import org.serratec.TrabalhoIndividualAPI.Repository.ProntuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProntuarioService {

    @Autowired
    private ProntuarioRepository prontuarioRepository;
    @Autowired
    private PacienteRepository pacienteRepository;



    public List<ProntuarioResponseDTO> listarProntuariosPorPacienteId(Long pacienteId) {
        if (!pacienteRepository.existsById(pacienteId)) {
            throw new ResourceNotFoundException("Paciente não encontrado");
        }
        List<Prontuario> prontuarios = prontuarioRepository.findByPaciente_Id(pacienteId);
        List<ProntuarioResponseDTO> response = new ArrayList<>();

        for (Prontuario p : prontuarios){
            ProntuarioResponseDTO dto = new ProntuarioResponseDTO(
                    p.getDataHoraConsulta(),
                    p.getDiagnostico(),
                    p.getEncaminhamento(),
                    p.getPaciente().getNome(),
                    p.getObservacao()

            );
            response.add(dto);
        }
        return response;
    }

    public List<ProntuarioResponseDTO> listarTodosProntuarios() {
        List<Prontuario> prontuarios = prontuarioRepository.findAll();
        List<ProntuarioResponseDTO> response = new ArrayList<>();

        for (Prontuario p : prontuarios){
            ProntuarioResponseDTO dto = new ProntuarioResponseDTO(
                    p.getDataHoraConsulta(),
                    p.getDiagnostico(),
                    p.getEncaminhamento(),
                    p.getPaciente().getNome(),
                    p.getObservacao()

            );
            response.add(dto);
        }
        return response;
    }

    public ProntuarioResponseDTO criarProntuario(ProntuarioRequestDTO dto){
        if (!pacienteRepository.existsById(dto.getPacienteID())) {
            throw new ResourceNotFoundException("Paciente não encontrado");
        }

        Prontuario novoProntuario = new Prontuario();
        novoProntuario.setDataHoraConsulta(dto.getDataHoraConsulta());
        novoProntuario.setDiagnostico(dto.getDiagnostico());
        novoProntuario.setEncaminhamento(dto.getEncaminhamento());
        novoProntuario.setObservacao(dto.getObservacao());
        novoProntuario.setPaciente(pacienteRepository.findById(dto.getPacienteID()).get());

        Prontuario prontuarioSalvo = prontuarioRepository.save(novoProntuario);

        return new ProntuarioResponseDTO(
                prontuarioSalvo.getDataHoraConsulta(),
                prontuarioSalvo.getDiagnostico(),
                prontuarioSalvo.getEncaminhamento(),
                prontuarioSalvo.getPaciente().getNome(),
                prontuarioSalvo.getObservacao()
        );
    }

    public ProntuarioResponseDTO buscarPorId(Long id){
        Prontuario prontuario = prontuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prontuário não encontrado"));

        return new ProntuarioResponseDTO(
                prontuario.getDataHoraConsulta(),
                prontuario.getDiagnostico(),
                prontuario.getEncaminhamento(),
                prontuario.getPaciente().getNome(),
                prontuario.getObservacao()
        );
    }

    public void deletarProntuario(Long id){
        if (!prontuarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Prontuário não encontrado");
        }
        prontuarioRepository.deleteById(id);
    }

    public ProntuarioResponseDTO atualizarProntuario(Long id, ProntuarioRequestDTO dto){
        if (!prontuarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Prontuário não encontrado");
        }
        if (!pacienteRepository.existsById(dto.getPacienteID())) {
            throw new ResourceNotFoundException("Paciente não encontrado");
        }

        Prontuario prontuario = prontuarioRepository.findById(id).get();
        prontuario.setDataHoraConsulta(dto.getDataHoraConsulta());
        prontuario.setDiagnostico(dto.getDiagnostico());
        prontuario.setEncaminhamento(dto.getEncaminhamento());
        prontuario.setObservacao(dto.getObservacao());
        prontuario.setPaciente(pacienteRepository.findById(dto.getPacienteID()).get());

        Prontuario prontuarioAtualizado = prontuarioRepository.save(prontuario);

        return new ProntuarioResponseDTO(
                prontuarioAtualizado.getDataHoraConsulta(),
                prontuarioAtualizado.getDiagnostico(),
                prontuarioAtualizado.getEncaminhamento(),
                prontuarioAtualizado.getPaciente().getNome(),
                prontuarioAtualizado.getObservacao()
        );
    }
}
