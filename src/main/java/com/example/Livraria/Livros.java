package com.example.Livraria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Criando os construtores do objeto
@Data
@NoArgsConstructor
@AllArgsConstructor

// Criando o objeto livros
public class Livros {
    private String capa;
    private String nome;
    private String autor;
    private String editora;
}
