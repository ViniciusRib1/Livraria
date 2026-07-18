package com.example.Livraria;

import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/registrar")
    public String registrar(@ModelAttribute Usuario usuarioDTO, HttpSession session, RedirectAttributes redirectAttributes) throws IOException {        
        Usuario usuarioExistente = usuarioRepository.findByEmail(usuarioDTO.getEmail());
    
        if (usuarioExistente != null) {
            redirectAttributes.addFlashAttribute("erro", "Usuário com esse gmail já cadastrado!");
            return "redirect:/usuarios/registrar";
        }
        
        if (usuarioDTO.getFoto() != null && !usuarioDTO.getFoto().isEmpty()) {
            String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/uploads/";
            File directory = new File(uploadDir);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            String fileName = System.currentTimeMillis() + "_" + usuarioDTO.getFoto().getOriginalFilename();
            usuarioDTO.getFoto().transferTo(new File(directory, fileName));
            usuarioDTO.setFotoString(fileName);
        }
        
        usuarioRepository.save(usuarioDTO); 
        session.setAttribute("usuario", usuarioDTO);
        return "redirect:/usuarios/livros"; 
    }

    @GetMapping("/registrar")
    public String exibirFormularioRegistro() {
        return "registro";
    }

    @PostMapping("/login")
    public String logar(@RequestParam String email, @RequestParam String senha, HttpSession session) {
        Usuario usuarioEncontrado = usuarioRepository.findByEmailAndSenha(email, senha);
        
        if (usuarioEncontrado != null) {
            session.setAttribute("usuario", usuarioEncontrado);
            
            return "redirect:/usuarios/livros";
        } else {
            return "redirect:/usuarios/login?erro=true";
        }
    }

    @GetMapping("/login")
    public String exibirFormularioLogin() {
        return "inicio-user";
    }

    @GetMapping("/livros")
    public String paginaLivros() {
        return "inicio-user"; 
    }

    @GetMapping("/livros-alugados")
    public String livrosAlugados() {
        return "alugados-user";
    }

    @GetMapping("/perfil")
    public String perfilUser() {
        return "perfil-user";
    }
}