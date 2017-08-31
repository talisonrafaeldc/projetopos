package dao;
import java.sql.*;
public class Conexao {
    
    Statement comando;
    ResultSet resultado;
    Connection conn;
    String sql;
    
public Connection AbriConexao(){
        try{ 
        Class.forName("org.gjt.mm.mysql.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/projetopos","root","1234");
        comando = conn.createStatement();
        System.out.println("Conexão Estabelecida com Sucesso!");
        }
        catch(ClassNotFoundException | SQLException cnfe){
            System.out.printf(cnfe.getMessage());
        }
        return conn;
}

public void Comando(String sql){
        try{
            comando.execute(sql);
            System.out.println("Gravado com Sucesso");
        }
        catch(SQLException sqlex){
            System.out.println(sqlex.getMessage());
            System.out.println("Não gravou");}
}
    
public ResultSet Busca(String sql){
        try{
            resultado = comando.executeQuery(sql);
            System.out.println("Busca Concluída");
        }
        catch(SQLException e){
            System.out.printf(e.getMessage());
            System.out.println("Erro na Busca");}
        return resultado;
}

public void fecharResultado(){
        if(resultado != null){
            try{
                resultado.close();
            }
            catch(Exception e){}
        }
}

public void fecharComando(){
        if(comando != null){
            try{
                comando.close();
            }
            catch(Exception e){}
        }
}

public void fecharConexao(){
        if(conn != null){
            try{
                conn.close();
            }
            catch(Exception e){}
        }
}

}