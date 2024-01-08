
package DAO;
import DTO.UsuarioDTO2;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Renata
 */
public class UsuarioDAO2 {
    Connection conn;
    public ResultSet autenticacao(UsuarioDTO2 objeto2){
        conn = new ConexaoDAO2().conectabd();        
        try {
            String sql = "Select * from usuario where nome = ? and senha = ? ";
            PreparedStatement ps =  conn.prepareStatement(sql);
            ps.setString(1, objeto2.getNome());
            ps.setString(2,objeto2.getSenha());
            
            ResultSet rs = ps.executeQuery();
            return rs;
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "AUTENTICACAO USUARIO "+e); 
              return null;
        }
      
        
    }
    
    
}
