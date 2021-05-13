
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;
import utils.Conexao;

/**
 *
 * @author WAGNER JOHNATAN
 */
public class UsuarioDAO {
    
    private Connection connection = (Connection) Conexao.getConexao();
    
    
    public void save ( Usuario usuario){
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO usuarios (nome,email,senha,telefone) VALUES (?,?,?,?)");
            ps.setString(1,"nome");
            ps.setString(2,"email");
            ps.setString(3,"senha");
            ps.setString(4,"telefone");
            ps.execute();
            JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        
    }
    }
        public void update ( Usuario usuario){
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE usuarios SET nome=?, email=?, senha=?,telefone=? WHERE id=?");
            ps.setString(1, usuario.getNome());
            ps.setString(2,usuario.getEmail());
            ps.setString(3,usuario.getSenha());
            ps.setString(4,usuario.getTelefone());
            ps.setInt(5,usuario.getId());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Usuario atualizado com sucesso!");
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        
    }
    }
        public void saveOrUpdate(Usuario usuario){
            if ( usuario.getId() == 0){
                save (usuario);
            }else{
                update(usuario);
            }
            
        }
        
        
                public void delete ( Usuario usuario){
        try {
            PreparedStatement ps = connection.prepareStatement(" DELETE FROM usuarios WHERE id=?");
            ps.setInt(1,usuario.getId());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Usuario atualizado com sucesso!");
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        
    }
    }
                    
       public List<Usuario> gettAll( ){
           List<Usuario> usuarios= new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(" SELECT * FROM usuarios");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTelefone(rs.getString("telefone"));
                usuarios.add(usuario);
            
            }  
            return usuarios;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        
    }
        return null;
    }
                 
            
    
}
