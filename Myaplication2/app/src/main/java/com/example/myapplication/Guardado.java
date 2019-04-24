package com.example.myapplication;

import java.util.Date;

public class Guardado {
    private String cliente, abogado;
    private Date fecha;

    public Guardado(String cliente, String abogado, Date fecha) {
        this.cliente = cliente;
        this.abogado = abogado;
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getAbogado() {
        return abogado;
    }

    public void setAbogado(String abogado) {
        this.abogado = abogado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Guardado{" +
                "cliente='" + cliente + '\'' +
                ", abogado='" + abogado + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}

