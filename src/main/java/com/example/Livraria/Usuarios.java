package com.example.Livraria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Inicializando os construtores
@Data
@NoArgsConstructor
@AllArgsConstructor

// Criando o objeto usuário
public class Usuarios {
    private String foto;
    private String nome;
    private String email;
    private String senha;
    private String livro;
}
