package com.example.projetotesteandroid.model;

public class ExperienciaProfissional {

    String cargo;
    String periodo;
    String local;
    String atividades;
    boolean selected;

    public ExperienciaProfissional(){

    }

    public ExperienciaProfissional(String cargo, String periodo, String local, String atividades) {
        this.cargo = cargo;
        this.periodo = periodo;
        this.local = local;
        this.atividades = atividades;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public boolean isSelected() {
        return selected;
    }

    public String getAtividades() {
        return atividades;
    }

    public void setAtividades(String atividades) {
        this.atividades = atividades;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
