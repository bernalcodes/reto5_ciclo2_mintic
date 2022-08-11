package com.bernalcodes.controller;

import java.util.List;
import java.sql.SQLException;

import com.bernalcodes.model.dao.*;
import com.bernalcodes.model.vo.*;

public class ReportesController {
    private ListaComprasClasificadasDao listaComprasClasificadasDao;
    private ListaProyectosClasificadosDao listaProyectosClasificadosDao;
    private ListaLideresDao listaLideresDao;

    public ReportesController() {
        listaComprasClasificadasDao = new ListaComprasClasificadasDao();
        listaProyectosClasificadosDao = new ListaProyectosClasificadosDao();
        listaLideresDao = new ListaLideresDao();
    }

    public List<ListaComprasClasificadasVo> listarComprasClasificadas() throws SQLException {
        return listaComprasClasificadasDao.listar();
    }

    public List<ListaProyectosClasificadosVo> listarProyectosClasificados() throws SQLException {
        return listaProyectosClasificadosDao.listar();
    }

    public List<ListaLideresVo> listarLideres() throws SQLException {
        return listaLideresDao.listar();
    }
}