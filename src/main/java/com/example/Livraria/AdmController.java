package com.example.Livraria;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/administrador")
public class AdmController {


    @PostMapping("/login")
    public String loginPost(@RequestParam String email, 
                            @RequestParam String senha, 
                            HttpSession session, 
                            RedirectAttributes redirectAttributes) {

        if ("viniciusribeiro0709@gmail.com".equals(email) && "adm@123".equals(senha)) {
            session.setAttribute("admLogado", true);
            return "redirect:/administrador/dashboard"; 
        } else {
            redirectAttributes.addFlashAttribute("erro", "Email ou senha incorretos!");
            return "redirect:/administrador/login";
        }
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
}