package org.serratec.TrabalhoIndividualAPI.DTO;


import org.serratec.TrabalhoIndividualAPI.Domain.Paciente;

import java.time.LocalDateTime;

public class ProntuarioResponseDTO {

    private String diagnostico;
    private LocalDateTime dataHoraConsulta;
    private String encaminhamento;
    private String observacao;
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

