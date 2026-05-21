package org.serratec.TrabalhoIndividualAPI.DTO;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

@Schema(description = "Dados para cadastro do médico")
public class MedicoRequestDTO {

    @Schema(description = "Nome do médico")
    @Size(max = 40, message = "Nome deve ter no máximo 40 caracteres")
    @NotBlank(message = "O campo Nome não pode estar vazio")
    private String nome;

    @Schema(description = "CRM do médico")
    @Size(max = 9, message = "CRM deve ter no máximo 9 caracteres")
    @NotBlank(message = "O campo CRM não pode estar vazio")
    private String crm;

    @Schema(description = "IDs das especialidades do médico")
    @NotEmpty(message = "O campo Especialidade não pode estar vazio.")
    private List<Long> especialidadeIds;


    public MedicoRequestDTO(String crm, List<Long> especialidadeIds, String nome) {
        this.crm = crm;
        this.especialidadeIds = especialidadeIds;
        this.nome = nome;
    }

    public MedicoRequestDTO() {
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public List<Long> getEspecialidadeIds() {
        return especialidadeIds;
    }

    public void setEspecialidadeIds(List<Long> especialidadeIds) {
        this.especialidadeIds = especialidadeIds;
    }

    public String getNome() {
        return nome;
    }



    public void setNome(String nome) {
        this.nome = nome;
    }
}
