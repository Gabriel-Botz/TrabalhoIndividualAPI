package org.serratec.TrabalhoIndividualAPI.Service;

import org.serratec.TrabalhoIndividualAPI.DTO.EspecialidadeResponseDTO;
import org.serratec.TrabalhoIndividualAPI.DTO.MedicoRequestDTO;
import org.serratec.TrabalhoIndividualAPI.DTO.MedicoResponseDTO;
import org.serratec.TrabalhoIndividualAPI.Domain.Medico;
import org.serratec.TrabalhoIndividualAPI.Exceptions.ResourceNotFoundException;
import org.serratec.TrabalhoIndividualAPI.Repository.EspecialidadeRepository;
import org.serratec.TrabalhoIndividualAPI.Repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicoService {

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    public MedicoResponseDTO criarMedico(MedicoRequestDTO dto) {
        var novoMedico = new Medico();
        novoMedico.setNome(dto.getNome());
        novoMedico.setCrm(dto.getCrm());
        novoMedico.setEspecialidades(especialidadeRepository.findAllById(dto.getEspecialidadeIds()));

        var medicoSalvo = medicoRepository.save(novoMedico);

        List<EspecialidadeResponseDTO> especialidadesDTO = medicoSalvo.getEspecialidades()
                .stream()
                .map(e -> new EspecialidadeResponseDTO(e.getId(), e.getNome()))
                .toList();

        return new MedicoResponseDTO(especialidadesDTO, medicoSalvo.getId(), medicoSalvo.getNome());
    }

    public MedicoResponseDTO atualizar(Long id, MedicoRequestDTO dto) {
        Medico medico = medicoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Médico não encontrado"));

        medico.setNome(dto.getNome());
        medico.setCrm(dto.getCrm());

        medico.setEspecialidades(especialidadeRepository.findAllById(dto.getEspecialidadeIds()));

        Medico medicoAtualizado = medicoRepository.save(medico);
        List<EspecialidadeResponseDTO> especialidadesDTO = medicoAtualizado.getEspecialidades()
                .stream()
                .map(e -> new EspecialidadeResponseDTO(e.getId(), e.getNome()))
                .toList();
                return new MedicoResponseDTO(especialidadesDTO, medicoAtualizado.getId(), medicoAtualizado.getNome());

    }

    public void deletarMedico(Long id) {
        var medico = medicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Médico não encontrado"));

        medicoRepository.delete(medico);
    }

    public MedicoResponseDTO obterMedicoPorId(Long id) {
        var medico = medicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Médico não encontrado"));

        List<EspecialidadeResponseDTO> especialidadesDTO = medico.getEspecialidades()
                .stream()
                .map(e -> new EspecialidadeResponseDTO(e.getId(), e.getNome()))
                .toList();

        return new MedicoResponseDTO(especialidadesDTO, medico.getId(), medico.getNome());
    }

    public List<MedicoResponseDTO> obterTodosMedicos() {
        var medicos = medicoRepository.findAll();

        return medicos.stream()
                .map(m -> {
                    List<EspecialidadeResponseDTO> especialidadesDTO = m.getEspecialidades()
                            .stream()
                            .map(e -> new EspecialidadeResponseDTO(e.getId(), e.getNome()))
                            .toList();
                    return new MedicoResponseDTO(especialidadesDTO, m.getId(), m.getNome());
                })
                .collect(Collectors.toList());
    }
}
