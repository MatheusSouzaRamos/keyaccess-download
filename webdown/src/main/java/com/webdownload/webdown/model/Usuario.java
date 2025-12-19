package com.webdownload.webdown.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String chave;
    private String navegadorNome;
    private String plataformaTipo;

    public Usuario(){}

    public Usuario(String nome, String chave, String navegadorNome, String plataformaTipo){
        this.nome = nome;
        this.chave = chave;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setChave(String chave){
        this.chave = chave;
    }

    public void setNavegadorNome(String navegadorNome){
        this.navegadorNome = navegadorNome;
    }

    public void setPlataformaTipo(String plataformaTipo){
        this.plataformaTipo = plataformaTipo;
    }

    public String getNome(){
        return nome;
    }

    public String getChave(){
        return chave;
    }

    public String getNavegadorNome(){
        return navegadorNome;
    }

        public String getPlataformaTipo(){
        return plataformaTipo;
    }
}