package com.example.Livraria;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Criando os construtores do objeto
@Data
@NoArgsConstructor
@AllArgsConstructor

// Criando o objeto livros
@Entity
@Table(name = "livros")
public class Livros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String capa;
    private String nome;
    private String autor;
    private String editora;
}
