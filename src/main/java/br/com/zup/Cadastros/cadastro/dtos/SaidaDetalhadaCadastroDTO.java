package br.com.zup.Cadastros.cadastro.dtos;

import java.time.LocalDate;

public class SaidaDetalhadaCadastroDTO {

    private String cpf;
    private String nome;
    private String sobrenome;
    private String cidade;
    private String bairro;
    private String nomeDoParenteProximo;
    private boolean moraSozinho;
    private boolean temPet;
    private int idade;
    private LocalDate dataDoCadastro;


    public SaidaDetalhadaCadastroDTO() {
    }

    public SaidaDetalhadaCadastroDTO(String cpf, String nome, String sobrenome, String cidade, String bairro,
                                     String nomeDoParenteProximo, boolean moraSozinho, boolean temPet, int idade,
                                     LocalDate dataDoCadastro) {
        this.cpf = cpf;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cidade = cidade;
        this.bairro = bairro;
        this.nomeDoParenteProximo = nomeDoParenteProximo;
        this.moraSozinho = moraSozinho;
        this.temPet = temPet;
        this.idade = idade;
        this.dataDoCadastro = dataDoCadastro;
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

    public LocalDate getDataDoCadastro() {
        return dataDoCadastro;
    }

    public void setDataDoCadastro(LocalDate dataDoCadastro) {
        this.dataDoCadastro = dataDoCadastro;
    }

}
