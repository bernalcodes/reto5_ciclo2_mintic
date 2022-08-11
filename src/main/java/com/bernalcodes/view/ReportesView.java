package com.bernalcodes.view;

import java.util.List;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

import com.bernalcodes.controller.ReportesController;
import com.bernalcodes.model.vo.*;

public class ReportesView extends JFrame implements ActionListener {
    private ReportesController controller;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem primerInf, segundoInf, tercerInf;
    private JTable tabla;
    private DefaultTableModel modelo;
    private JLabel lblTitulo, lblConsulta, lblResultado;

    public ReportesView() {
        controller = new ReportesController();
        menu();
        etiqueta1();
        etiqueta2();
        tabla();
        etiqueta3();
        setLayout(new FlowLayout());
        setSize(600, 400);
        setVisible(true);
        setResizable(false);
        setTitle("Informes - Reto 5");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void menu() {
        menuBar = new JMenuBar();   
        setJMenuBar(menuBar);
        menu = new JMenu("Informes");
        menuBar.add(menu);
        primerInf = new JMenuItem("Primer informe");
        segundoInf = new JMenuItem("Segundo informe");
        tercerInf = new JMenuItem("Tercer informe");
        menu.add(primerInf);
        menu.add(segundoInf);
        menu.add(tercerInf);
        primerInf.addActionListener(this);
        segundoInf.addActionListener(this);
        tercerInf.addActionListener(this);
    }

    public void etiqueta1() {
        lblTitulo = new JLabel("Informe Reto 5");
        lblTitulo.setPreferredSize(new Dimension(500, 30));
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblTitulo);
    }

    public void etiqueta2() {
        lblConsulta = new JLabel();
        lblConsulta.setPreferredSize(new Dimension(500, 30)); 
        lblConsulta.setFont(new Font("Arial", Font.BOLD, 14));
        add(lblConsulta);
    }

    public void etiqueta3() {
        lblResultado = new JLabel();
        lblResultado.setPreferredSize(new Dimension(500, 30)); 
        lblResultado.setFont(new Font("Arial", Font.BOLD, 12));
        add(lblResultado);
    }

    public void tabla() {
        tabla = new JTable(modelo);
        tabla.setPreferredScrollableViewportSize(new Dimension(500, 208));
        tabla.setFillsViewportHeight(true);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tabla.setDefaultRenderer(Object.class, centerRenderer);

        add(tabla);
        JScrollPane pane = new JScrollPane(tabla);
        add(pane);
    }

    public void listarComprasClasificadas() {
        try {
            List<ListaComprasClasificadasVo> listaComprasClasificadas = controller.listarComprasClasificadas();
            
            modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Constructora");
            modelo.addColumn("Banco");

            for (ListaComprasClasificadasVo compraClasificadaVo : listaComprasClasificadas) {
                Object[] filaCompra = new Object[3];
                filaCompra[0] = compraClasificadaVo.getId();
                filaCompra[1] = compraClasificadaVo.getConstructora();
                filaCompra[2] = compraClasificadaVo.getBanco();
                modelo.addRow(filaCompra);
            }

            tabla.setModel(modelo);
            modelo.fireTableDataChanged();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarProyectosClasificados() {
        try {
            List<ListaProyectosClasificadosVo> listaProyectosClasificados = controller.listarProyectosClasificados();

            modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Constructora");
            modelo.addColumn("Habitaciones");
            modelo.addColumn("Ciudad");

            for (ListaProyectosClasificadosVo proyectoClasificadoVo : listaProyectosClasificados) {
                Object[] filaProyecto = new Object[4];
                filaProyecto[0] = proyectoClasificadoVo.getId();
                filaProyecto[1] = proyectoClasificadoVo.getConstructora();
                filaProyecto[2] = proyectoClasificadoVo.getHabitaciones();
                filaProyecto[3] = proyectoClasificadoVo.getCiudad();
                modelo.addRow(filaProyecto);
            }

            tabla.setModel(modelo);
            modelo.fireTableDataChanged();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarLideres() {
        try {
            List<ListaLideresVo> listaDeComprasDeLider = controller.listarLideres();
            
            modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Ciudad");

            for (ListaLideresVo comprasDeLiderVo : listaDeComprasDeLider) {
                Object[] filaLider = new Object[4];
                filaLider[0] = comprasDeLiderVo.getId();
                filaLider[1] = comprasDeLiderVo.getNombre();
                filaLider[2] = comprasDeLiderVo.getApellido();
                filaLider[3] = comprasDeLiderVo.getCiudad();
                modelo.addRow(filaLider);
            }

            tabla.setModel(modelo);
            modelo.fireTableDataChanged();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == primerInf) {
            listarLideres();
            lblConsulta.setText("Consulta de líderes.");
            lblResultado.setText("Se obtuvieron " + tabla.getRowCount() + " resultados.");
        }

        if (e.getSource() == segundoInf) {
            listarProyectosClasificados();
            lblConsulta.setText("Consulta de proyectos clasificados");
            lblResultado.setText("Se obtuvieron " + tabla.getRowCount() + " resultados.");
        }

        if (e.getSource() == tercerInf) {
            listarComprasClasificadas();
            lblConsulta.setText("Consulta de compras clasificadas");
            lblResultado.setText("Se obtuvieron " + tabla.getRowCount() + " resultados.");
        }
    }
}