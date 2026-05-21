package org.serratec.TrabalhoIndividualAPI.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Retorno do paciente")
public class PacienteResponseDTO {

    @Schema(description = "ID do paciente")
    private Long id;
    @Schema(description = "Nome do paciente")
    private String nome;
    @Schema(description = "Email do paciente")
    private String email;
    @Schema(description = "Telefone do paciente")
    private String telefone;


    public PacienteResponseDTO(Long id, String nome, String email, String telefone) {

        this.id = id;
        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }
}
