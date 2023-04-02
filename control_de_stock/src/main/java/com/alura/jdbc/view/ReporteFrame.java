package com.alura.jdbc.view;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.alura.jdbc.controller.CategoriaController;
import com.alura.jdbc.controller.ProductoController;

public class ReporteFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTable tablaReporte;
    private DefaultTableModel modelo;

    private CategoriaController categoriaController;

    public ReporteFrame(ControlDeStockFrame controlDeStockFrame) {
        super("Reporte de produtos del stock");

        this.categoriaController = new CategoriaController();

        Container container = getContentPane();
        setLayout(null);

        tablaReporte = new JTable();
        tablaReporte.setBounds(0, 0, 600, 400);
        container.add(tablaReporte);

        modelo = (DefaultTableModel) tablaReporte.getModel();
        modelo.addColumn("");
        modelo.addColumn("");
        modelo.addColumn("");
        modelo.addColumn("");

        cargaReporte();

        setSize(600, 400);
        setVisible(true);
        setLocationRelativeTo(controlDeStockFrame);
    }

    private void cargaReporte() {
        var contenido = categoriaController.cargaReporte();

        contenido.forEach(categoria -> {
            modelo.addRow(new Object[] {categoria});

            var productos = categoria.getProductos();

            productos.forEach(producto -> modelo.addRow(
                new Object[]{
                        "",
                        producto.getNombre(),
                        producto.getCantidad()
                }
            ));
        });
    }
    /*
    Malas practicas, genera N+1 Queries;
    * var contenido = categoriaController.cargaReporte();

        contenido.forEach(categoria -> {
            modelo.addRow(new Object[] {categoria});

            var productos = this.productoController.listar(categoria);

            productos.forEach(producto -> modelo.addRow(
                new Object[]{
                        "",
                        producto.getNombre(),
                        producto.getCantidad()
                }
            ));
        });
    *
    *
    *
    * */

}
