package com.webdownload.webdown.service;

import org.springframework.stereotype.Service;

import com.webdownload.webdown.model.ChaveAcesso;
import com.webdownload.webdown.repository.ChaveRepository;

import java.util.Optional;

@Service
public class ChaveService {
    
    private final ChaveRepository chaveRepository;

    public ChaveService(ChaveRepository chaveRepository){
        this.chaveRepository = chaveRepository;
    }

    public boolean validarChave(String chave){
        Optional<ChaveAcesso> chaveOp = chaveRepository.findByChaveAndUtilizavel(chave, true);
        return chaveOp.isPresent();
    }

    public void invalidarChave(String chave){
        Optional<ChaveAcesso> chaveOp = chaveRepository.findByChaveAndUtilizavel(chave, true);
        if(chaveOp.isPresent()){
            ChaveAcesso chaveInvalidar = chaveOp.get();
            chaveInvalidar.setUtilizavel(false);
            chaveRepository.save(chaveInvalidar);
        }
    }

    
}
