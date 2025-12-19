package com.webdownload.webdown.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "chave")
public class ChaveAcesso {
    
    @Id
    private String chave;
    private boolean utilizavel;

    public ChaveAcesso() {}

    public ChaveAcesso (String chave, boolean utilizavel){
        this.chave = chave;
        this.utilizavel = utilizavel;
    }

    public void setUtilizavel(boolean utilizavel){
        this.utilizavel = utilizavel;
    }

    public String getChave(){
        return chave;
    }

    public boolean getUtilizavel(){
        return utilizavel;
    }
}
