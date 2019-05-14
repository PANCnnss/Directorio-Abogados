package com.example.myapplication;

import java.util.Date;

public class Comentario {
    private String idCliente, idAbogado;
    private int calificacion;
    private String coment, rama;
    private Date fecha;

    public Comentario(String idCliente, String idAbogado, int calificación, String coment, String rama, Date fecha) {
        this.idCliente = idCliente;
        this.idAbogado = idAbogado;
        this.calificacion = calificación;
        this.coment = coment;
        this.rama = rama;
        this.fecha = fecha;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdAbogado() {
        return idAbogado;
    }

    public void setIdAbogado(String idAbogado) {
        this.idAbogado = idAbogado;
    }

    public int getCalificación() {
        return calificacion;
    }

    public void setCalificación(int calificación) {
        this.calificacion = calificación;
    }

    public String getComent() {
        return coment;
    }

    public void setComent(String coment) {
        this.coment = coment;
    }

    public String getRama() {
        return rama;
    }

    public void setRama(String rama) {
        this.rama = rama;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "idCliente='" + idCliente + '\'' +
                ", idAbogado='" + idAbogado + '\'' +
                ", calificación=" + calificacion +
                ", coment='" + coment + '\'' +
                ", rama='" + rama + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}
