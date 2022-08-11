package com.bernalcodes.model.dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.List;
import java.util.ArrayList;

import com.bernalcodes.model.vo.ListaComprasClasificadasVo;
import com.bernalcodes.util.JDBCUtilities;

public class ListaComprasClasificadasDao {
    /**
     * Returns a list with the Projects and their info per provided Bank
     * @param banco
     * @return
     * @throws SQLException
     */
    public List<ListaComprasClasificadasVo> listar() throws SQLException {
        List<ListaComprasClasificadasVo> listaCompras = new ArrayList<ListaComprasClasificadasVo>();

        Connection conn = JDBCUtilities.getConnection();
        Statement stm = conn.createStatement();
        ResultSet rs = null;

        String query = "SELECT Compra.ID_Compra AS id, Proyecto.Constructora, Proyecto.Banco_Vinculado AS banco FROM Compra INNER JOIN Proyecto ON Compra.ID_Proyecto=Proyecto.ID_Proyecto WHERE Compra.Proveedor = 'Homecenter' AND Proyecto.Ciudad = 'Salento';";

        try {
            rs = stm.executeQuery(query);

            while (rs.next()) {
                ListaComprasClasificadasVo compra = new ListaComprasClasificadasVo();
                compra.setId(rs.getInt("id"));
                compra.setConstructora(rs.getString("constructora"));
                compra.setBanco(rs.getString("banco"));
                listaCompras.add(compra);
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
        return listaCompras;
    }
}