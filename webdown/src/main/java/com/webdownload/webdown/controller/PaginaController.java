package com.webdownload.webdown.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaginaController {

    @GetMapping("/download")
    public ModelAndView download(HttpSession session) {


        System.out.println("[PaginaController] Verificando acesso... ID da Sessão: " + session.getId());
        System.out.println("[PaginaController] Valor de 'acessoLiberado': " + session.getAttribute("acessoLiberado"));

        Boolean acesso = (Boolean) session.getAttribute("acessoLiberado");

        if (acesso != null && acesso) {
            return new ModelAndView("download");
        } else {
            return new ModelAndView("redirect:/login.html");
        }
    }
}
