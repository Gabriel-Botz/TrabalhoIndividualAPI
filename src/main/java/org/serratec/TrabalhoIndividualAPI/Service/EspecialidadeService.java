package org.serratec.TrabalhoIndividualAPI.Service;

import org.serratec.TrabalhoIndividualAPI.DTO.EspecialidadeRequestDTO;
import org.serratec.TrabalhoIndividualAPI.DTO.EspecialidadeResponseDTO;
import org.serratec.TrabalhoIndividualAPI.Domain.Especialidade;
import org.serratec.TrabalhoIndividualAPI.Exceptions.ResourceNotFoundException;
import org.serratec.TrabalhoIndividualAPI.Repository.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadeService {

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    public EspecialidadeResponseDTO buscarEspecialidadePorId(Long id) {
        return especialidadeRepository.findById(id)
                .map(e -> new EspecialidadeResponseDTO(e.getId(), e.getNome()))
                .orElseThrow(() -> new ResourceNotFoundException("Especialidade não encontrada"));
    }

    public List<EspecialidadeResponseDTO> listarTodasEspecialidades() {
        List<EspecialidadeResponseDTO> especialidades = especialidadeRepository.findAll()
                .stream()
                .map(e -> new EspecialidadeResponseDTO(e.getId(), e.getNome()))
                .toList();
        return especialidades;
    }

    public EspecialidadeResponseDTO criarEspecialidade(EspecialidadeRequestDTO dto) {
        var novaEspecialidade = new Especialidade();
        novaEspecialidade.setNome(dto.getNome());
        var especialidadeSalva = especialidadeRepository.save(novaEspecialidade);
        return new EspecialidadeResponseDTO(especialidadeSalva.getId(), especialidadeSalva.getNome());
    }

    public EspecialidadeResponseDTO atualizarEspecialidade(Long id, EspecialidadeRequestDTO dto) {
        var especialidade = especialidadeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Especialidade não encontrada"));

        especialidade.setNome(dto.getNome());
        Especialidade atualizada = especialidadeRepository.save(especialidade);

        return new EspecialidadeResponseDTO(atualizada.getId(), atualizada.getNome());
    }

    public void deletarEspecialidade(Long id) {
        if (!especialidadeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Especialidade não encontrada");
        }
        especialidadeRepository.deleteById(id);
    }
}
