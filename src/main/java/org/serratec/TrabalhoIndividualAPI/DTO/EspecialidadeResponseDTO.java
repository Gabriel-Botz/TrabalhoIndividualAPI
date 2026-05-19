package org.serratec.TrabalhoIndividualAPI.DTO;

public class EspecialidadeResponse {

    private Long id;
    private String nome;

    public EspecialidadeResponse(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
