
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
            
        connection connection = (connection) DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\WAGNER JOHNATAN\\Desktop\\BANCO DE DADOS\\pitang", "SA", "1234");
        System.out.println("conectador com sucesso!");
        return connection;
        
        } catch ( SQLException e){
            
            System.out.println("Erro AO CONECTAR COM O CANCO DE DADOS !\nErro:  " +e);
            
        }
        
        return null;
        
    }
    
 
    
}
