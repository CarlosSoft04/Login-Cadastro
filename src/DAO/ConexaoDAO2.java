
package DAO;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos
 */
public class ConexaoDAO2 {
    
    public Connection conectabd(){
        Connection conn = null;
        
        try {
            String url = "jdbc:mysql://localhost:3306/bancoteste?user=root&password=usuario";
            conn = DriverManager.getConnection(url);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "CONEXAO COM BANCO DE DADOS "+ e.getMessage());
        }
        return conn;
        
    }
    
}
