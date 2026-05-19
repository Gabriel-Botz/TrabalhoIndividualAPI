package org.serratec.TrabalhoIndividualAPI.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class PacienteRequestDTO {

    @Size(max = 40, message = "Nome deve ter no máximo 40 caracteres")
    @NotBlank(message = "O campo Nome não pode estar vazio")
    private String nome;

    @Size(max = 11, message = "CPF deve ter no máximo 11 caracteres")
    @NotBlank(message = "O campo CPF não pode estar vazio")
    private String cpf;

    @NotNull(message = "A data de nascimento é obrigatória")
    private LocalDate dataNascimento;

    @Size(max = 40, message = "Email deve ter no máximo 40 caracteres")
    @Email(message = "Email inválido")
    @NotBlank(message = "O campo Email não pode estar vazio")
    private String email;

    @Size(max = 11, message = "Telefone deve ter no máximo 11 caracteres")
    @NotBlank(message = "O campo Telefone não pode estar vazio")
    private String telefone;

    public PacienteRequestDTO(String cpf, LocalDate dataNascimento, String email, String nome, String telefone) {
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
    }

    public PacienteRequestDTO() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}


