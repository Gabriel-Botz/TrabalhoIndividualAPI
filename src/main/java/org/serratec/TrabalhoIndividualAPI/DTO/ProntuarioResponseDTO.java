package org.serratec.TrabalhoIndividualAPI.DTO;


import io.swagger.v3.oas.annotations.media.Schema;
import org.serratec.TrabalhoIndividualAPI.Domain.Paciente;

import java.time.LocalDateTime;

@Schema(description = "Retorno do prontuário")
public class ProntuarioResponseDTO {

    @Schema(description = "Diagnóstico do paciente")
    private String diagnostico;
    @Schema(description = "Data e hora da consulta")
    private LocalDateTime dataHoraConsulta;
    @Schema(description = "Encaminhamento do paciente")
    private String encaminhamento;
    @Schema(description = "Observação do paciente")
    private String observacao;
    @Schema(description = "Nome do paciente")
    private String nomePaciente;

    public ProntuarioResponseDTO(LocalDateTime dataHoraConsulta, String diagnostico, String encaminhamento, String nomePaciente, String observacao) {
        this.dataHoraConsulta = dataHoraConsulta;
        this.diagnostico = diagnostico;
        this.encaminhamento = encaminhamento;
        this.nomePaciente = nomePaciente;
        this.observacao = observacao;
    }

    public LocalDateTime getDataHoraConsulta() {
        return dataHoraConsulta;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public String getEncaminhamento() {
        return encaminhamento;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public String getObservacao() {
        return observacao;
    }
}

