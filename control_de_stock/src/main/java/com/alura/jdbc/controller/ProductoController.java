package com.alura.jdbc.controller;

import com.alura.jdbc.factory.ConnectionFactory;
import com.alura.jdbc.models.Categoria;
import com.alura.jdbc.models.Producto;
import com.alura.jdbc.DAO.ProductoDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductoController {
	private ProductoDAO productoDAO;

	public ProductoController() {
		this.productoDAO = new ProductoDAO(new ConnectionFactory().recuperarConexion());
	}

	public int modificar(Producto producto) {
		return productoDAO.modificar(producto);
	}

	public int eliminar(Integer id) {
		return productoDAO.eliminar(id);

	}

	public List<Producto> listar() {
		return productoDAO.listar();
	}

	public List<Producto> listar(Categoria categoria){
		return productoDAO.listar(categoria.getId());
	}

    public void guardar(Producto producto, Integer categoriaID) {
		producto.setCategoriaID(categoriaID);
		productoDAO.guardar(producto);
	}
}
