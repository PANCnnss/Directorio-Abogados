    package com.example.myapplication;

<<<<<<< HEAD
import java.io.Serializable;

public class Cliente implements Serializable {
    private String id, correo, password, nombre, apellido;
=======
public class Cliente {
    private String id, correo, nombre, apellido;
>>>>>>> 15c8038bb003dc18361fdbe6b219abf853318f2f

    public Cliente(String id, String correo, String nombre, String apellido) {
        this.id = id;
        this.correo = correo;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id='" + id + '\'' +
                ", correo='" + correo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
