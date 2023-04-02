package com.alura.jdbc.DAO;

import com.alura.jdbc.models.Categoria;
import com.alura.jdbc.models.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    private final Connection connection;

    public CategoriaDAO(Connection connection){ this.connection = connection; }

    public List<Categoria> listar(){
        List<Categoria> categorias = new ArrayList<>();
        try{
            final PreparedStatement statement = connection.prepareStatement("SELECT * FROM CATEGORIA");

            try(statement){
                final var resultSet = statement.executeQuery();
                try(resultSet){
                    while(resultSet.next()){
                        int id = resultSet.getInt("id");
                        String nombre = resultSet.getString("nombre");
                        categorias.add(new Categoria(id, nombre));
                    }
                }
            }
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return categorias;
    }
    public List<Categoria> listarConProductos(){
        List<Categoria> categorias = new ArrayList<>();
        try{
            final PreparedStatement statement = connection.prepareStatement(
                    "SELECT C.ID, C.NOMBRE, P.ID, P.NOMBRE, P.CANTIDAD " +
                        "FROM CATEGORIA C " +
                        "INNER JOIN PRODUCTO P " +
                        "ON C.ID=P.CATEGORIA_ID;");

            try(statement){
                final var resultSet = statement.executeQuery();
                try(resultSet){
                    while(resultSet.next()){
                        // Categoria
                        Integer idCategoria = resultSet.getInt("C.ID");
                        String nombreCategoria = resultSet.getString("C.NOMBRE");

                        var categoria = categorias
                                .stream()
                                .filter(cat -> cat.getId().equals(idCategoria))
                                .findAny().orElseGet(() -> {
                                    Categoria cat = new Categoria(idCategoria, nombreCategoria);
                                    categorias.add(cat);
                                    return cat;
                                });
                        // Producto
                        Integer idProducto = resultSet.getInt("P.ID");
                        String nombreProducto = resultSet.getString("P.NOMBRE");
                        Integer cantidadProducto = resultSet.getInt("P.CANTIDAD");
                        var producto = new Producto(idProducto, nombreProducto, cantidadProducto);
                        categoria.agregar(producto);
                    }
                }
            }
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return categorias;
    }
}
