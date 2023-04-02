package com.alura.jdbc.models;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private Integer id;
    private String nombre;

    private List<Producto> productos;

    public Categoria(int id, String nombre){ this.id = id; this.nombre = nombre; }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregar(Producto producto){
        if (productos == null) productos = new ArrayList<>();

        this.productos.add(producto);
    }

    public List<Producto> getProductos() { return this.productos; }

    @Override
    public String toString(){
        return nombre;
    }
}
