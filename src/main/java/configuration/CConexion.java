package configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import javax.swing.JOptionPane;

public class CConexion {
    
    Connection conectar = null;

    public Connection conectarme(){
        try {
//            // Carga del archivo de propiedades
//            Properties prop = new Properties();
//            prop.load(getClass().getClassLoader().getResourceAsStream("configuration/config.properties"));

//            // Lectura de propiedades
//            String usuario = prop.getProperty("db.usuario");
//            String contra = prop.getProperty("db.contra");
//            String db = prop.getProperty("db.nombre");
//            String ip = prop.getProperty("db.ip");
//            String puerto = prop.getProperty("db.puerto");

            String usuario ="root";
            String contra = "12345";
            String db = "dbstore";
            String ip = "localhost";
            String puerto = "3306";



            String cadena = "jdbc:mysql://" + ip + ":" + puerto + "/" + db;

            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena, usuario, contra);
            JOptionPane.showMessageDialog(null, "Conexion correcta a la base de datos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se conectó a la base de datos: " + e.toString());
        }
        return conectar;
    }

    public void cerrarConexion(){
        try {
            if (conectar != null && !conectar.isClosed()) {
                conectar.close();
                JOptionPane.showMessageDialog(null, "La conexión fue cerrada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo cerrar la conexión: " + e.toString());
        }
    }
}
