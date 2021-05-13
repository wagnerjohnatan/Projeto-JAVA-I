
package utils;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author WAGNER JOHNATAN
 */
public class Conexao {
    public static connection getConexao(){
        try{
            
        connection connection = (connection) DriverManager.getConnection("jdbc:mysql:localhost:3306", "root", "");
        System.out.println("conectador com sucesso!");
        return connection;
        
        } catch ( SQLException e){
            
            System.out.println("Erro AO CONECTAR COM O CANCO DE DADOS !\nErro:  " +e);
            
        }
        
        return null;
        
    }
    
 
    
}
