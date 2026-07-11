package com.example.Livraria;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Inicializando os construtores
@Data
@NoArgsConstructor
@AllArgsConstructor

// Criando o objeto usuário
public class Usuario {
    private String id;
    private String fotoString; 
    private transient MultipartFile foto;
    private String nome;
    private String email;
    private String senha;
    private String livro;
}
