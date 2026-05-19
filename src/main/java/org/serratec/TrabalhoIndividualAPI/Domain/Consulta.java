package org.serratec.TrabalhoIndividualAPI.Domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_hora_agendamento")
    private LocalDateTime dataHoraAgendamento;

    private String observacao;

    @ManyToOne
    @JoinColumn(name = "fk_medico")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "fk_paciente")
    private Paciente paciente;

    public Consulta() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Consulta consulta = (Consulta) o;
        return Objects.equals(id, consulta.id) && Objects.equals(dataHoraAgendamento, consulta.dataHoraAgendamento) && Objects.equals(observacao, consulta.observacao) && Objects.equals(medico, consulta.medico) && Objects.equals(paciente, consulta.paciente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataHoraAgendamento, observacao, medico, paciente);
    }

    public LocalDateTime getDataHoraAgendamento() {
        return dataHoraAgendamento;
    }

    public void setDataHoraAgendamento(LocalDateTime dataHoraAgendamento) {
        this.dataHoraAgendamento = dataHoraAgendamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
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

    public Consulta(LocalDateTime dataHoraAgendamento, Long id, Medico medico, String observacao, Paciente paciente) {
        this.dataHoraAgendamento = dataHoraAgendamento;
        this.id = id;
        this.medico = medico;
        this.observacao = observacao;
        this.paciente = paciente;
    }
}
