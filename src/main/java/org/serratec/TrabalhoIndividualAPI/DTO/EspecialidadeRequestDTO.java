package org.serratec.TrabalhoIndividualAPI.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Dados para cadastro da especialidade")
public class EspecialidadeRequestDTO {

    @Schema(description = "Nome da especialidade")
    @Size(max = 40, message = "Nome deve ter no máximo 40 caracteres")
    @NotBlank(message = "O campo Nome não pode estar vazio")
    private String nome;

    public EspecialidadeRequestDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
