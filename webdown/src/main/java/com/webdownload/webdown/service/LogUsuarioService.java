package com.webdownload.webdown.service;

import org.springframework.stereotype.Service;

import com.webdownload.webdown.model.UsuarioLog;
import com.webdownload.webdown.repository.UsuarioLogRepository;

@Service
public class LogUsuarioService {

    private final UsuarioLogRepository usuarioLogRepository;

    public LogUsuarioService(UsuarioLogRepository usuarioLogRepository) {
        this.usuarioLogRepository = usuarioLogRepository;
    }

    public UsuarioLog salvar(String nome, String chave, String navegadorNome, String plataformaTipo) {
        UsuarioLog usuarioLog = new UsuarioLog(nome, chave, navegadorNome, plataformaTipo);
        return usuarioLogRepository.save(usuarioLog);
    }
}
