package com.alura.jdbc.models;

public class Producto {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer cantidad;
    private Integer categoriaID;
    public Producto(Integer id, String nombre, String descripcion, Integer cantidad){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }
    public Producto(Integer id, String nombre, String descripcion){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    public Producto(Integer id, String nombre, Integer cantidad){
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }
    public Producto(String nombre, String descripcion, Integer cantidad){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
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

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }

    public Integer getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(Integer categoriaID) {
        this.categoriaID = categoriaID;
    }

    @Override
    public String toString(){
        return String.format("Producto: %d, Nombre: %s, Descripcion: %s, Cantidad: %d", id, nombre, descripcion, cantidad);
    }

}
