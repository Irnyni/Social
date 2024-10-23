package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Post")
public class Postagem {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) 
  private Long id;
  private String titulo;
  private String conteudo;
  private String imagem;
public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public String getTitulo() {
    return titulo;
}
public void setTitulo(String titulo) {
    this.titulo = titulo;
}
public String getConteudo() {
    return conteudo;
}
public void setConteudo(String conteudo) {
    this.conteudo = conteudo;
}
public String getImagem() {
    return imagem;
}
public void setImagem(String imagem) {
    this.imagem = imagem;
}
public Postagem() {
}
  
}
