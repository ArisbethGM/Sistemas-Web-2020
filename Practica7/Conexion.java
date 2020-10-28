package mx.uv.basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static String url = "jdbc:mysql://127.0.0.1:3306/ejemplo_simple?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false";
    private static String driverName = "com.mysql.cj.jdbc.Driver";

    private static String user = "root";
    private static String password = "";
    private static Connection connection = null;

    public static Connection geConnection(){
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Success connection!");

        } catch (SQLException e) {
            System.out.println("Falled to create the database connection!");
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            System.out.println("Driver not found!");
        }
        return connection;
    }

}
