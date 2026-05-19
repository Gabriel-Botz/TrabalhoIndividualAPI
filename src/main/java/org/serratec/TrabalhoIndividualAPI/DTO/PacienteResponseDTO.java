package org.serratec.TrabalhoIndividualAPI.DTO;

public class PacienteResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private String telefone;

    public PacienteResponseDTO(String email, Long id, String nome, String telefone) {

        this.email = email;
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }
}
