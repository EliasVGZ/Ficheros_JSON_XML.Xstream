package EXAMEN.ConectandoconMYSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mysql {

    public static Connection conectar() {
        Connection con = null;

        String usuario = "root";
        String password = "Abc123.";

        String url = "jdbc:mysql://localhost:3306/bibliotecas?useSSL=false&serverTimezone=UTC&user=" + usuario
                + "&password=" + password;
        try {
            con = DriverManager.getConnection(url);
            if (con != null) {
                System.out.println("Conectado");
            }
        } catch (SQLException e) {
            System.out.println("No se pudo conectar a la base de datos");
            e.printStackTrace();
        }
        return con;
    }
}
