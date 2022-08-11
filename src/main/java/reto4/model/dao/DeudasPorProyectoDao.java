package reto4.model.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import reto4.util.*;

import reto4.model.vo.DeudasPorProyectoVo;


public class DeudasPorProyectoDao {
    public List<DeudasPorProyectoVo> listar() throws SQLException {
        ArrayList<DeudasPorProyectoVo> respuesta = new ArrayList<DeudasPorProyectoVo>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        String consulta = "SELECT ID_Compra as id , p.Constructora, p.Banco_Vinculado as banco FROM Compra c Join Proyecto p on c.ID_Proyecto = p.ID_Proyecto WHERE Proveedor = 'Homecenter' and p.Ciudad ='Salento'";

        try{
            stm = conn.createStatement();
           
            rs = stm.executeQuery(consulta);
            while(rs.next()){
                DeudasPorProyectoVo vo = new DeudasPorProyectoVo();
                vo.setId(rs.getInt("id"));
                vo.setConstructora(rs.getString("constructora"));
                vo.setBanco(rs.getString("banco"));
                respuesta.add(vo);
            }
        }
        finally{
            if (rs != null){
                rs.close();
            }
            if (stm != null){
            stm.close();
            }
            if (conn != null){
                conn.close();
            }
        }
        return respuesta;
    }
}
