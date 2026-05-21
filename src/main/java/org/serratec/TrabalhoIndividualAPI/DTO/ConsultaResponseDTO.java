package org.serratec.TrabalhoIndividualAPI.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Dados para cadastro de consulta")
public class ConsultaResponseDTO {

    @Schema(description = "ID da consulta")
    private Long id;
    @Schema(description = "Data e hora do agendamento da consulta")
    private LocalDateTime dataHoraAgendamento;
    @Schema(description = "Observação sobre a consulta")
    private String observacao;
    @Schema(description = "Nome do médico")
    private String nomeMedico;
    @Schema(description = "Nome do paciente")
    private String nomePaciente;

    public ConsultaResponseDTO(LocalDateTime dataHoraAgendamento, Long id, String nomeMedico, String nomePaciente, String observacao) {
        this.dataHoraAgendamento = dataHoraAgendamento;
        this.id = id;
        this.nomeMedico = nomeMedico;
        this.nomePaciente = nomePaciente;
        this.observacao = observacao;
    }

    public LocalDateTime getDataHoraAgendamento() {
        return dataHoraAgendamento;
    }

    public Long getId() {
        return id;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public String getObservacao() {
        return observacao;
    }
}

