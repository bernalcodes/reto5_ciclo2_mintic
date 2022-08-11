package com.bernalcodes.model.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.util.List;
import java.util.ArrayList;

import com.bernalcodes.model.vo.ListaProyectosClasificadosVo;
import com.bernalcodes.util.JDBCUtilities;

public class ListaProyectosClasificadosDao {
    /**
     * Returns a list with the ID of the material and the total amount of Debt per material for a provided Project
     * @return
     * @throws SQLException
     */
    public List<ListaProyectosClasificadosVo> listar() throws SQLException {
        List<ListaProyectosClasificadosVo> listaProyectos = new ArrayList<ListaProyectosClasificadosVo>();

        Connection conn = JDBCUtilities.getConnection();
        Statement stm = conn.createStatement();
        ResultSet rs = null;

        String query = "SELECT ID_Proyecto AS id, Constructora, Numero_Habitaciones AS habitaciones, Ciudad FROM Proyecto WHERE Clasificacion = 'Casa Campestre' AND Ciudad IN ('Santa Marta', 'Barranquilla', 'Cartagena')";

        try {
            rs = stm.executeQuery(query);

            while (rs.next()) {
                ListaProyectosClasificadosVo proyecto = new ListaProyectosClasificadosVo();
                proyecto.setId(rs.getInt("id"));
                proyecto.setConstructora(rs.getString("constructora"));
                proyecto.setHabitaciones(rs.getInt("habitaciones"));
                proyecto.setCiudad(rs.getString("ciudad"));
                listaProyectos.add(proyecto);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            
            if (stm != null) {
                stm.close();
            }
            
            if (conn != null) {
                conn.close();
            }
        }
        return listaProyectos;
    }
}
