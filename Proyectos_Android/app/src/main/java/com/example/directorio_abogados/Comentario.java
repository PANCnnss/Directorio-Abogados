package com.example.directorio_abogados;

import java.util.Date;

public class Comentario {
    private int idCliente, idAbogado, calificación;
    private String coment, rama;
    private Date fecha;

    public Comentario(int idCliente, int idAbogado, int calificación, String coment, String rama, Date fecha) {
        this.idCliente = idCliente;
        this.idAbogado = idAbogado;
        this.calificación = calificación;
        this.coment = coment;
        this.rama = rama;
        this.fecha = fecha;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdAbogado() {
        return idAbogado;
    }

    public void setIdAbogado(int idAbogado) {
        this.idAbogado = idAbogado;
    }

    public int getCalificación() {
        return calificación;
    }

    public void setCalificación(int calificación) {
        this.calificación = calificación;
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
                "idCliente=" + idCliente +
                ", idAbogado=" + idAbogado +
                ", calificación=" + calificación +
                ", coment='" + coment + '\'' +
                ", rama='" + rama + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}
