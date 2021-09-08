package com.example.projetotesteandroid.model;

public class Curso {

    String titulo;
    String descricao;
    String certificado;
    boolean selected;

    public Curso(){

    }

    public Curso(String titulo, String descricao, String certificado) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.certificado = certificado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
