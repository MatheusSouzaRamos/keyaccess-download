package com.webdownload.webdown.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "LogTable")
public class UsuarioLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String chave;
    private String dataHora;
    private String navegadorNome;
    private String plataformaTipo;
    
    public UsuarioLog(){}

    public UsuarioLog(String nome, String chave, String navegadorNome, String plataformaTipo){
        this.nome = nome;
        this.chave = chave;
        this.dataHora = obterDataHora();
        this.navegadorNome = navegadorNome;
        this.plataformaTipo = plataformaTipo;
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

    private String obterDataHora(){
        Calendar c = Calendar.getInstance();
		Date data = c.getTime();
		DateFormat dtHora = DateFormat.getDateTimeInstance();
		System.out.println(dtHora.format(data));
        String dataFormatada = dtHora.format(data);
        return dataFormatada;
    }
}
