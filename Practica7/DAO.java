package mx.uv.basededatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//import com.mysql.jdbc.PreparedStatement;

public class DAO {
    private static Conexion conexion = new Conexion();

    public static List<Usuarios> dameUsuarios(){
        Statement stm = null;
        Connection con = null;
        ResultSet rs = null;
        List<Usuarios> resultado = new ArrayList<>();

        con = conexion.geConnection();
        try {
            String sql = "SELECT = FROM usuarios";
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()){
                Usuarios u = new Usuarios( rs.getString("id"), rs.getString("email"), rs.getString("password"));
                resultado.add(u);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                rs  = null;
            }
            if(stm != null){
                try {
                    stm.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                stm = null;
            }
            try {
                con.close();
                System.out.print("Closed connection!");
            } catch (Exception e) {
                e.printStackTrace();    
            }
        }
        return resultado;
    }


    /*public static String crearUsuarios(Usuarios u){
        PreparedStatement stm = null;
        Connection con = null;
        ResultSet rs = null;
        List<Usuarios> resultado = new ArrayList<>();
        String msj = "";

        con = conexion.geConnection();
        try {
            String sql = "INSECT INTO usuarios (id, email, password) VALUES (?,?,?)";
            stm = con.prepareStatement(sql)
            stm.setString(1, u.getId());
            stm.setString(2, u.getEmail();
            stm.setString(3, u.getPassword());
            stm.setString(4, u.getId());
            
            while(rs.next()){
                Usuarios u = new Usuarios( rs.getString("id"), rs.getString("email"), rs.getString("password"));
                resultado.add(u);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                rs  = null;
            }
            if(stm != null){
                try {
                    stm.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                stm = null;
            }
            try {
                con.close();
                System.out.print("Closed connection!");
            } catch (Exception e) {
                e.printStackTrace();    
            }
        }
        return resultado;
    }*/
}
