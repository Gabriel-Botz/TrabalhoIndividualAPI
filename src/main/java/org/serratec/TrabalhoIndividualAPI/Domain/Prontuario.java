package org.serratec.TrabalhoIndividualAPI.Domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "prontuario")
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;

    private String diagnostico;

    @Column(name = "data_hora_consulta")
    private LocalDateTime dataHoraConsulta;

    private String encaminhamento;

    private String observacao;

    @OneToOne
    @JoinColumn(name = "fk_paciente")
    private Paciente paciente;

    public Prontuario(LocalDateTime dataHoraConsulta, String diagnostico, String encaminhamento, Long id, String observacao, Paciente paciente) {
        this.dataHoraConsulta = dataHoraConsulta;
        this.diagnostico = diagnostico;
        this.encaminhamento = encaminhamento;
        this.id = id;
        this.observacao = observacao;
        this.paciente = paciente;
    }

    public Prontuario() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Prontuario that = (Prontuario) o;
        return Objects.equals(id, that.id) && Objects.equals(diagnostico, that.diagnostico) && Objects.equals(dataHoraConsulta, that.dataHoraConsulta) && Objects.equals(encaminhamento, that.encaminhamento) && Objects.equals(observacao, that.observacao) && Objects.equals(paciente, that.paciente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, diagnostico, dataHoraConsulta, encaminhamento, observacao, paciente);
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
