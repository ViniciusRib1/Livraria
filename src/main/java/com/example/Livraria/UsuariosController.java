package com.example.Livraria;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

import org.springframework.core.io.Resource; // Importação correta

import java.io.File;
import java.io.IOException;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.http.MediaType;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

    @PostMapping("/registrar")
    public String registrar(@ModelAttribute Usuario usuarioDTO, HttpSession session) throws IOException {
        if (usuarioDTO.getFoto() != null && !usuarioDTO.getFoto().isEmpty()) {
            String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/uploads/";
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String fileName = System.currentTimeMillis() + "_" + usuarioDTO.getFoto().getOriginalFilename();
        // Salva usando o caminho absoluto garantido
        usuarioDTO.getFoto().transferTo(new File(directory, fileName));
        usuarioDTO.setFotoString(fileName);
        }
        
        session.setAttribute("usuario", usuarioDTO);
        return "redirect:/usuarios/livros";
    }

    @GetMapping("/registrar")
    public String exibirFormularioRegistro() {
        return "registro";
    }

    @GetMapping("/livros")
    public String testeDireto() {
        return "inicio-user";
    }

    @GetMapping("/livros-alugados")
    public String livrosAlugados() {
        return "alugados-user";
    }

    @GetMapping("/perfil")
    public String pefilUser() {
        return "perfil-user";
    }

    @GetMapping("/sair")
    public String sair() {
        return "redirect:index.html";
    }
    
}