package br.com.zup.Cadastros.cadastro.dtos;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CadastroDTO {

    @CPF(message = "CPDF inválido")
    private String cpf;
    @Size(min = 3, message = "O nome deve ter no mínimo 3 caracteres")
    @NotBlank
    private String nome;
    @Size(min = 2,message = "O sobrenome deve  ter no mínimo 2 caracteres")
    @NotBlank
    private String sobrenome;
    @Size(min = 3, message = "A cidade deve ter no mínimo 3 caracteres")
    @NotBlank
    private String cidade;
    @Size(min = 3, message = "O bairro deve ter no mínimo 3 caracteres")
    @NotBlank
    private String bairro;
    private String nomeDoParenteProximo;
    private boolean moraSozinho;
    private boolean temPet;
    @Min(0)
    private int idade;


    public CadastroDTO() {
    }

    public CadastroDTO(String cpf, String nome, String sobrenome, String cidade, String bairro,
                       String nomeDoParenteProximo, boolean moraSozinho, boolean temPet, int idade) {
        this.cpf = cpf;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cidade = cidade;
        this.bairro = bairro;
        this.nomeDoParenteProximo = nomeDoParenteProximo;
        this.moraSozinho = moraSozinho;
        this.temPet = temPet;
        this.idade = idade;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNomeDoParenteProximo() {
        return nomeDoParenteProximo;
    }

    public void setNomeDoParenteProximo(String nomeDoParenteProximo) {
        this.nomeDoParenteProximo = nomeDoParenteProximo;
    }

    public boolean isMoraSozinho() {
        return moraSozinho;
    }

    public void setMoraSozinho(boolean moraSozinho) {
        this.moraSozinho = moraSozinho;
    }

    public boolean isTemPet() {
        return temPet;
    }

    public void setTemPet(boolean temPet) {
        this.temPet = temPet;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}
