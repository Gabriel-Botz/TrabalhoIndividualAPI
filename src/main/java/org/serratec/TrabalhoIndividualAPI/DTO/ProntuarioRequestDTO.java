package org.serratec.TrabalhoIndividualAPI.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Schema(description = "Dados para cadastro do prontuário")
public class ProntuarioRequestDTO {

    @NotNull(message = "O ID do paciente é obrigatório.")
    @Schema(description = "ID do paciente")
    private Long pacienteID;

    @Schema(description = "Diagnóstico do paciente")
    @Size(max = 40, message = "Diagnóstico deve ter no máximo 40 caracteres")
    @NotBlank(message = "O campo Diagnóstico não pode estar vazio")
    private String diagnostico;

    @NotNull(message = "A data e hora da consulta é obrigatória")
    @Schema(description = "Data e hora da consulta")
    private LocalDateTime dataHoraConsulta;

    @Schema(description = "Encaminhamento do paciente")
    @Size(max = 40, message = "Encaminhamento deve ter no máximo 40 caracteres")
    @NotBlank(message = "O campo Encaminhamento não pode estar vazio")
    private String encaminhamento;

    @Schema(description = "Observação do paciente")
    @Size(max = 40, message = "Observação deve ter no máximo 40 caracteres")
    @NotBlank(message = "O campo Observação não pode estar vazio")
    private String observacao;

    public ProntuarioRequestDTO(LocalDateTime dataHoraConsulta, String diagnostico, String encaminhamento, String observacao, Long pacienteID) {
        this.dataHoraConsulta = dataHoraConsulta;
        this.diagnostico = diagnostico;
        this.encaminhamento = encaminhamento;
        this.observacao = observacao;
        this.pacienteID = pacienteID;
    }

    public ProntuarioRequestDTO() {
    }

    public LocalDateTime getDataHoraConsulta() {
        return dataHoraConsulta;
    }

    public void setDataHoraConsulta(LocalDateTime dataHoraConsulta) {
        this.dataHoraConsulta = dataHoraConsulta;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getEncaminhamento() {
        return encaminhamento;
    }

    public void setEncaminhamento(String encaminhamento) {
        this.encaminhamento = encaminhamento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Long getPacienteID() {
        return pacienteID;
    }

    public void setPacienteID(Long pacienteID) {
        this.pacienteID = pacienteID;
    }
}
