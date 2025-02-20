package configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class CConexion {
    
    Connection conectar = null;
    
    String usuario ="root";
    String contra = "12345";
    String db = "dbstore";
    String ip = "localhost";
    String puerto = "3306";
    String cadena = "Jdbc:mysql://"+ip+":"+puerto+"/"+db;
    
    public Connection conectarme(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena, usuario, contra);
            JOptionPane.showMessageDialog(null, "Conexion correcta a la base de datos");   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se Conecto a la base de datos: "+ e.toString());
        }
        return conectar;
    }
    
    
    
    public void cerrarConexion(){
        try {
            if (conectar != null && !conectar.isClosed()) {
                conectar.close();
            JOptionPane.showMessageDialog(null, "La conexion fue cerrada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo cerrar la conexion: "+ e.toString());
        }
    }
    
    
    
    
    
    
}
