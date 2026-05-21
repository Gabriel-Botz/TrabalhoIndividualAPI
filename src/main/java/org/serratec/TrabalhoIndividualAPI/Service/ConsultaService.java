package org.serratec.TrabalhoIndividualAPI.Service;

import org.serratec.TrabalhoIndividualAPI.DTO.ConsultaRequestDTO;
import org.serratec.TrabalhoIndividualAPI.DTO.ConsultaResponseDTO;
import org.serratec.TrabalhoIndividualAPI.Domain.Consulta;
import org.serratec.TrabalhoIndividualAPI.Domain.Medico;
import org.serratec.TrabalhoIndividualAPI.Domain.Paciente;
import org.serratec.TrabalhoIndividualAPI.Exceptions.ResourceNotFoundException;
import org.serratec.TrabalhoIndividualAPI.Repository.ConsultaRepository;
import org.serratec.TrabalhoIndividualAPI.Repository.MedicoRepository;
import org.serratec.TrabalhoIndividualAPI.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public ConsultaResponseDTO criarConsulta(ConsultaRequestDTO dto) {
        Medico medico = medicoRepository.findById(dto.getMedicoID())
                .orElseThrow(() -> new ResourceNotFoundException("Médico não encontrado"));

        Paciente paciente = pacienteRepository.findById(dto.getPacienteID())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado"));

        var novaConsulta = new Consulta();
        novaConsulta.setDataHoraAgendamento(dto.getDataHoraAgendamento());
        novaConsulta.setObservacao(dto.getObservacao());
        novaConsulta.setMedico(medico);
        novaConsulta.setPaciente(paciente);

        var consultaSalva = consultaRepository.save(novaConsulta);

        return new ConsultaResponseDTO(consultaSalva.getDataHoraAgendamento(), consultaSalva.getId(), medico.getNome(), paciente.getNome(), consultaSalva.getObservacao());
    }

    public ConsultaResponseDTO atualizar(Long id, ConsultaRequestDTO dto) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consulta não encontrada"));

        Medico medico = medicoRepository.findById(dto.getMedicoID())
                .orElseThrow(() -> new ResourceNotFoundException("Médico não encontrado"));

        Paciente paciente = pacienteRepository.findById(dto.getPacienteID())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado"));

        consulta.setDataHoraAgendamento(dto.getDataHoraAgendamento());
        consulta.setObservacao(dto.getObservacao());
        consulta.setMedico(medico);
        consulta.setPaciente(paciente);

        Consulta consultaAtualizada = consultaRepository.save(consulta);

        return new ConsultaResponseDTO(consultaAtualizada.getDataHoraAgendamento(), consultaAtualizada.getId(), medico.getNome(), paciente.getNome(), consultaAtualizada.getObservacao());
    }

    public void deletarConsulta(Long id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consulta não encontrada"));

        consultaRepository.delete(consulta);
    }

    public ConsultaResponseDTO obterConsultaPorId(Long id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consulta não encontrada"));

        return new ConsultaResponseDTO(consulta.getDataHoraAgendamento(), consulta.getId(), consulta.getMedico().getNome(), consulta.getPaciente().getNome(), consulta.getObservacao());
    }

    public List<ConsultaResponseDTO> obterTodasConsultas() {
        var consultas = consultaRepository.findAll();

        return consultas.stream()
                .map(c -> new ConsultaResponseDTO(c.getDataHoraAgendamento(), c.getId(), c.getMedico().getNome(), c.getPaciente().getNome(), c.getObservacao()))
                .collect(Collectors.toList());
    }
}
