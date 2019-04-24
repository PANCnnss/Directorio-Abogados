package com.example.myapplication;
import java.util.Date;

public class Abogado {
    private int veces_visto, peso;
    private String id, nombre, apellido, correo, telefono;
    private String rama1, rama2, otras_ramas, nro_colegio, fijo, ciudad;
    private String descripcion, idiomas, paginaw;
    private float calificacion, numopi;
    private boolean verificado;
    private Date fechanac;

    public Abogado(int veces_visto, int peso, String id, String nombre, String apellido, String correo, String telefono, String rama1, String rama2, String otras_ramas, String nro_colegio, String fijo, String ciudad, String descripcion, String idiomas, String paginaw, float calificacion, float numopi, boolean verificado, Date fechanac) {
        this.veces_visto = veces_visto;
        this.peso = peso;
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.rama1 = rama1;
        this.rama2 = rama2;
        this.otras_ramas = otras_ramas;
        this.nro_colegio = nro_colegio;
        this.fijo = fijo;
        this.ciudad = ciudad;
        this.descripcion = descripcion;
        this.idiomas = idiomas;
        this.paginaw = paginaw;
        this.calificacion = calificacion;
        this.numopi = numopi;
        this.verificado = verificado;
        this.fechanac = fechanac;
    }

    public int getVeces_visto() {
        return veces_visto;
    }

    public void setVeces_visto(int veces_visto) {
        this.veces_visto = veces_visto;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRama1() {
        return rama1;
    }

    public void setRama1(String rama1) {
        this.rama1 = rama1;
    }

    public String getRama2() {
        return rama2;
    }

    public void setRama2(String rama2) {
        this.rama2 = rama2;
    }

    public String getOtras_ramas() {
        return otras_ramas;
    }

    public void setOtras_ramas(String otras_ramas) {
        this.otras_ramas = otras_ramas;
    }

    public String getNro_colegio() {
        return nro_colegio;
    }

    public void setNro_colegio(String nro_colegio) {
        this.nro_colegio = nro_colegio;
    }

    public String getFijo() {
        return fijo;
    }

    public void setFijo(String fijo) {
        this.fijo = fijo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public String getPaginaw() {
        return paginaw;
    }

    public void setPaginaw(String paginaw) {
        this.paginaw = paginaw;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public float getNumopi() {
        return numopi;
    }

    public void setNumopi(float numopi) {
        this.numopi = numopi;
    }

    public boolean isVerificado() {
        return verificado;
    }

    public void setVerificado(boolean verificado) {
        this.verificado = verificado;
    }

    public Date getFechanac() {
        return fechanac;
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }

    @Override
    public String toString() {
        return "Abogado{" +
                "veces_visto=" + veces_visto +
                ", peso=" + peso +
                ", id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", rama1='" + rama1 + '\'' +
                ", rama2='" + rama2 + '\'' +
                ", otras_ramas='" + otras_ramas + '\'' +
                ", nro_colegio='" + nro_colegio + '\'' +
                ", fijo='" + fijo + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", idiomas='" + idiomas + '\'' +
                ", paginaw='" + paginaw + '\'' +
                ", calificacion=" + calificacion +
                ", numopi=" + numopi +
                ", verificado=" + verificado +
                ", fechanac=" + fechanac +
                '}';
    }
}
