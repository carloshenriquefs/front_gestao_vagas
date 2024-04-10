package com.rockseat.front_gestao_vagas.modules.candidate.controller;

import com.rockseat.front_gestao_vagas.modules.candidate.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping("/login.html")
    public String login() {
        return "candidate/login.html";
    }

    @PostMapping("/signIn")
    public String signIn(RedirectAttributes redirectAttributes, String username, String password) {

        try {
            var token = this.candidateService.login(username, password);

            return "redirect:/candidate/profile.html";

        } catch (HttpClientErrorException e) {
            redirectAttributes.addFlashAttribute("error_message", "Usuário/Senha incorretos");
            return "redirect:/candidate/login.html";
        }
    }
}
