package com.example.projetotesteandroid.model;

public class Habilidades {

    String tipo;
    String habilidades;
    boolean selected;


    public Habilidades(){

    }

    public Habilidades(String tipo, String habilidades) {
        this.tipo = tipo;
        this.habilidades = habilidades;

    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
