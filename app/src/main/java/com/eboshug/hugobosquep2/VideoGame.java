package com.eboshug.hugobosquep2;

public class VideoGame {
    private String nombre;
    private String descripcion;
    private float precio;
    private int img_id;
    int nuevo;
    int descuento;
    String consola;

    public VideoGame(String nombre, String descripcion, float precio, int img_id, int nuevo, int descuento, String consola) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.img_id = img_id;
        this.nuevo = nuevo;
        this.descuento = descuento;
        this.consola = consola;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getImg_id() {
        return img_id;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }

    public int getNuevo() {
        return nuevo;
    }

    public void setNuevo(int nuevo) {
        this.nuevo = nuevo;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public String getConsola() {
        return consola;
    }

    public void setConsola(String consola) {
        this.consola = consola;
    }

}
