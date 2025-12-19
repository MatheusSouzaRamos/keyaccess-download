package com.webdownload.webdown.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.webdownload.webdown.model.Usuario;
import com.webdownload.webdown.service.LogUsuarioService;
import com.webdownload.webdown.service.ChaveService;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class FormController{

    private final LogUsuarioService logUsuarioService;
    private final ChaveService chaveService;

    public FormController(LogUsuarioService logUsuarioService, ChaveService chaveService){
        this.logUsuarioService = logUsuarioService;
        this.chaveService = chaveService;
    }

    @PostMapping("/enviar")
    public ResponseEntity<Map<String, String>> receberForm(@RequestBody Usuario usuario, HttpSession session){
        logUsuarioService.salvar(usuario.getNome(), usuario.getChave(), usuario.getNavegadorNome(), usuario.getPlataformaTipo());

        Map<String, String> resp = new HashMap<>();
        if (chaveService.validarChave(usuario.getChave())){
            chaveService.invalidarChave(usuario.getChave());
            session.setAttribute("acessoLiberado", true);
            System.out.println("[FormController] Acesso liberado! ID da Sessão: " + session.getId());
            resp.put("mensagem", "ACESSO_LIBERADO");
            return ResponseEntity.ok(resp);
        } else {
            resp.put("mensagem", "CHAVE_INVALIDA");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(resp);
        }
    }
}
