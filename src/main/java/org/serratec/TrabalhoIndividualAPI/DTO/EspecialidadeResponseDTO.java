package org.serratec.TrabalhoIndividualAPI.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Retorno da especialidade")
public class EspecialidadeResponseDTO {

    @Schema(description = "ID da especialidade")
    private Long id;
    @Schema(description = "Nome da especialidade")
    private String nome;

    public EspecialidadeResponseDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
