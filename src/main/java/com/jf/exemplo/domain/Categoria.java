package com.jf.exemplo.domain;

import java.io.Serializable;
import java.util.Objects;

public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer ID;

    private String nome;

    public Categoria() {

    }

    public Categoria(Integer ID, String nome) {
        this.ID = ID;
        this.nome = nome;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Categoria categoria)) return false;
        return Objects.equals(ID, categoria.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ID);
    }
}
