package com.bernalcodes.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bernalcodes.model.vo.ListaLideresVo;
import com.bernalcodes.util.JDBCUtilities;

public class ListaLideresDao {
    /**
     * Returns a list with the Top 10 Leaders per spending amount
     * @return
     * @throws SQLException
     */
    public List<ListaLideresVo> listar() throws SQLException {
        List<ListaLideresVo> listaLideres = new ArrayList<ListaLideresVo>();

        Connection conn = JDBCUtilities.getConnection();
        Statement stm = conn.createStatement();
        ResultSet rs = null;

        String query = "SELECT ID_Lider AS id, Nombre, Primer_Apellido AS apellido, Ciudad_Residencia AS ciudad FROM Lider ORDER BY Ciudad_Residencia";

        try {
            rs = stm.executeQuery(query);

            while (rs.next()) {
                ListaLideresVo lider = new ListaLideresVo();
                lider.setId(rs.getInt("id"));
                lider.setNombre(rs.getString("Nombre"));
                lider.setApellido(rs.getString("Apellido"));
                lider.setCiudad(rs.getString("Ciudad"));
                listaLideres.add(lider);
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
        return listaLideres;
    }
}