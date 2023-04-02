package com.alura.jdbc.DAO;

import com.alura.jdbc.models.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductoDAO {
    private final Connection connection;

    public ProductoDAO(Connection connection){
        this.connection = connection;
    }

    public Integer modificar(Producto producto){
        try{
            final PreparedStatement preparedStatement = connection.prepareStatement("UPDATE PRODUCTO SET NOMBRE=?, DESCRIPCION=? WHERE ID=?;");
            try(preparedStatement){
                preparedStatement.setString(1, producto.getNombre());
                preparedStatement.setString(2, producto.getDescripcion());
                preparedStatement.setInt(3, producto.getId());
                preparedStatement.execute();
                int cantidadModificado = preparedStatement.getUpdateCount();
                return cantidadModificado;
            }
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }

    public Integer eliminar(Integer id){
        try{
            final PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM PRODUCTO WHERE ID=?;");

            try(preparedStatement){

                preparedStatement.setInt(1, id);
                preparedStatement.execute();
                int cantidad = preparedStatement.getUpdateCount();

                return cantidad;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Producto> listar(){
        List<Producto> resultado = new ArrayList<>();
        try {
            final Statement statement = connection.createStatement();
            try(statement){
                statement.execute("SELECT ID, NOMBRE, DESCRIPCION, CANTIDAD FROM producto;");
                final ResultSet resultset = statement.getResultSet();
                try(resultset){

                    while (resultset.next()) {
                        Producto fila = new Producto(
                                resultset.getInt("ID"),
                                resultset.getString("NOMBRE"),
                                resultset.getString("DESCRIPCION"),
                                resultset.getInt("CANTIDAD")
                        );
                        resultado.add(fila);
                    }
                    return resultado;
                }
            }
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }

    public void guardar(Producto producto){
        try{
            final PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO producto(nombre, descripcion, cantidad, categoria_id) VALUES (?,?,?,?);",
                    Statement.RETURN_GENERATED_KEYS
            );

            try (preparedStatement){
                ejecutaRegistro(producto, preparedStatement);
            }

        }catch (SQLException ex){

            throw new RuntimeException(ex);
        }
    }

    private static void ejecutaRegistro(Producto producto, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, producto.getNombre());
        preparedStatement.setString(2, producto.getDescripcion());

        preparedStatement.setInt(3, producto.getCantidad());
        preparedStatement.setInt(4, producto.getCategoriaID());

        preparedStatement.execute();

        final ResultSet resultSet = preparedStatement.getGeneratedKeys();

        try(resultSet){
            while(resultSet.next()){
                producto.setId(resultSet.getInt(1));
                System.out.println("Se ha insertado el " + producto);
            }
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }

    public List<Producto> listar(Integer categoriaID){
        List<Producto> resultado = new ArrayList<>();
        try {
            final PreparedStatement statement = connection.prepareStatement(
                    "SELECT ID, NOMBRE, DESCRIPCION, CANTIDAD " +
                        "FROM producto " +
                        "WHERE categoria_id=?;"
            );
            try(statement){
                statement.setInt(1, categoriaID);
                statement.execute();
                final ResultSet resultset = statement.getResultSet();
                try(resultset){

                    while (resultset.next()) {
                        Producto fila = new Producto(
                                resultset.getInt("ID"),
                                resultset.getString("NOMBRE"),
                                resultset.getString("DESCRIPCION"),
                                resultset.getInt("CANTIDAD")
                        );
                        resultado.add(fila);
                    }
                    return resultado;
                }
            }
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
}
