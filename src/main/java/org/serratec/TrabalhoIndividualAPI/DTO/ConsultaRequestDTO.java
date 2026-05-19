package org.serratec.TrabalhoIndividualAPI.DTO;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class ConsultaRequestDTO {

    @NotNull(message = "A data da consulta é obrigatória.")
    private LocalDateTime dataHoraAgendamento;

    @Size(max = 40, message = "Observação deve ter no máximo 40 caracteres.")
    @NotBlank(message = "O campo Observação não pode estar vazio.")
    private String observacao;

    @NotNull(message = "O ID do médico é obrigatório.")
    private Long medicoID;

    @NotNull(message = "O ID do paciente é obrigatório.")
    private Long pacienteID;

    public ConsultaRequestDTO(LocalDateTime dataHoraAgendamento, Long medicoID, String observacao, Long pacienteID) {
        this.dataHoraAgendamento = dataHoraAgendamento;
        this.medicoID = medicoID;
        this.observacao = observacao;
        this.pacienteID = pacienteID;
    }

    public ConsultaRequestDTO() {
    }

    public LocalDateTime getDataHoraAgendamento() {
        return dataHoraAgendamento;
    }

    public void setDataHoraAgendamento(LocalDateTime dataHoraAgendamento) {
        this.dataHoraAgendamento = dataHoraAgendamento;
    }

    public Long getMedicoID() {
        return medicoID;
    }

    public void setMedicoID(Long medicoID) {
        this.medicoID = medicoID;
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
