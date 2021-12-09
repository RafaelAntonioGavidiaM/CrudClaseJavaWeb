package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;


public class Conexion {
    private static final String URL="jdbc:mysql://localhost:3306/control_clientes";
    private static final String USER="root";
    private static final String PASSWORD="";
    
    private static BasicDataSource dataSource;
    
    public static BasicDataSource getDataSource(){
        if (dataSource==null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl(URL);
            dataSource.setUsername(USER);
            dataSource.setPassword(PASSWORD);
            dataSource.setInitialSize(50);
        }
        return dataSource;
    }
    public static Connection getConnection()throws SQLException{
        return getDataSource().getConnection();
    }
    
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
