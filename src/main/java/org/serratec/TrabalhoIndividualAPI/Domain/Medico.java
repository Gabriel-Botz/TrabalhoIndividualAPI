package org.serratec.TrabalhoIndividualAPI.Domain;


import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String crm;

    @ManyToMany
    @JoinTable(name = "medico_especialidade",
            joinColumns = @JoinColumn(name = "fk_medico"),
            inverseJoinColumns = @JoinColumn(name = "fk_especialidade"))
    private List<Especialidade> especialidades;

    public Medico(String crm, List<Especialidade> especialidades, Long id, String nome) {
        this.crm = crm;
        this.especialidades = especialidades;
        this.id = id;
        this.nome = nome;
    }

    public Medico() {
    }

    @Override
    public String toString() {
        return "Medico{" +
                "crm='" + crm + '\'' +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                ", especialidades=" + especialidades +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Medico medico = (Medico) o;
        return Objects.equals(id, medico.id) && Objects.equals(nome, medico.nome) && Objects.equals(crm, medico.crm) && Objects.equals(especialidades, medico.especialidades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, crm, especialidades);
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public List<Especialidade> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidade> especialidades) {
        this.especialidades = especialidades;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
