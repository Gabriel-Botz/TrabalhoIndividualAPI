package org.serratec.TrabalhoIndividualAPI.DTO;

import java.util.List;

public class MedicoResponseDTO {

    private Long id;
    private String nome;
    private List<EspecialidadeResponseDTO> especialidades;

    public MedicoResponseDTO(List<EspecialidadeResponseDTO> especialidades, Long id, String nome) {
        this.especialidades = especialidades;
        this.id = id;
        this.nome = nome;
    }

    public List<EspecialidadeResponseDTO> getEspecialidades() {
        return especialidades;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
