package org.serratec.TrabalhoIndividualAPI.DTO;

import java.time.LocalDateTime;

public class ConsultaResponseDTO {

    private Long id;
    private LocalDateTime dataHoraAgendamento;
    private String observacao;
    private String nomeMedico;
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

