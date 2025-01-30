package com.tads.creche.Model;

public class Aluno {
    private int id;
    private String nome;
    private int idade;
    private int serie;

    public Aluno() {

    }

    public Aluno(int id, String nome, int idade, int serie) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.serie = serie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", serie=" + serie +
                '}';
    }
}