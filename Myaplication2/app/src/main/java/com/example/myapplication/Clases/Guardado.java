package com.example.myapplication.Clases;

import java.util.Date;

public class Guardado {
    private int cliente, abogado;
    private Date fecha;

    public Guardado(int cliente, int abogado, Date fecha) {
        this.cliente = cliente;
        this.abogado = abogado;
        this.fecha = fecha;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getAbogado() {
        return abogado;
    }

    public void setAbogado(int abogado) {
        this.abogado = abogado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
