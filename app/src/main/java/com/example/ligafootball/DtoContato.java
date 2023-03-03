package com.example.ligafootball;
public class DtoContato {private int id;
    private String nome, liga, pais, campeonato;

    public DtoContato(String nome, String liga, String pais, String campeonato) {
        this.nome = nome;
        this.liga = liga;
        this.pais = pais;
        this.campeonato = campeonato;
    }

    public DtoContato(){

    }

    @Override
    public String toString() {
        return nome + " - " + liga;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    // nome do Time
    public String getNome() { return nome; }
    public void setNome(String nome) {
        this.nome = nome;
    }

    // nome da liga
    public String getLiga() {
        return liga;
    }
    public void setLiga(String liga) {
        this.liga = liga;
    }

    // pais

    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }

    //campeonato

    public String getCampeonato() {
        return campeonato;
    }
    public void setCampeonato(String campeonato) {
        this.campeonato = campeonato;
    }


}


