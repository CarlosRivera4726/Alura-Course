package com.alura.jdbc.controller;

import com.alura.jdbc.DAO.CategoriaDAO;
import com.alura.jdbc.factory.ConnectionFactory;
import com.alura.jdbc.models.Categoria;

import java.util.ArrayList;
import java.util.List;

public class CategoriaController {
    private CategoriaDAO categoriaDAO;

    public  CategoriaController(){
        this.categoriaDAO = new CategoriaDAO(new ConnectionFactory().recuperarConexion());
    }

	public List<Categoria> listar() {
		return categoriaDAO.listar();
	}

    public List<Categoria> cargaReporte() {
        return this.categoriaDAO.listarConProductos();
    }

}
