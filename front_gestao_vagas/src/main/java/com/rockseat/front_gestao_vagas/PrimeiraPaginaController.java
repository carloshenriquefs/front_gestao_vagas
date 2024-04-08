package com.rockseat.front_gestao_vagas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PrimeiraPaginaController {

    @GetMapping("/home")
    public String primeiraPaginaHtml(Model model) {

        model.addAttribute("mensagemDaController", "Primeira Mensagem vindo da controller");
        return "primeiraPagina";
    }

    @GetMapping("/login")
    public String loginCandidate() {
        return "candidate/login";
    }

    @PostMapping("/create")
    public String cadastroCandidate(Pessoa pessoa) {
        System.out.println("Nome: " + pessoa.nome);
        System.out.println("Email: " + pessoa.email);
        System.out.println("Usuario: " + pessoa.usuario);

        return "redirect:/login";
    }

    record Pessoa(String usuario, String email, String nome) {}

}