package com.example.Livraria;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Inicializando os construtores
@Data
@NoArgsConstructor
@AllArgsConstructor

// Criando o objeto usuário
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fotoString; 
    private transient MultipartFile foto;
    private String nome;
    private String email;
    private String senha;
    private String livro;
}
