package org.serratec.TrabalhoIndividualAPI.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Retorno do médico")
public class MedicoResponseDTO {

    @Schema(description = "ID do médico")
    private Long id;
    @Schema(description = "Nome do médico")
    private String nome;
    @Schema(description = "Especialidades do médico")
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
