package dao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlunoDAO {
    public static String cadastrar(Integer cpf, String nome, String datanascimento, String login, String senha, String tipo, String email){
            boolean matriculando = true;
            int i = 0;
            Conexao conexao = new Conexao();
            conexao.AbriConexao();
            String insert = ("insert into userinfo (user, pass, tipo) values ('"+login+"',md5('"+senha+"'),'"+tipo+"') ");
            conexao.Comando(insert);
            ResultSet r = conexao.Busca("select id from userinfo where user='"+login+"' and pass=md5('"+senha+"')");
        try {
            if(r.next()){
                i = r.getInt("id");
                System.out.println(i);
                System.out.println(datanascimento);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            conexao.Comando("insert into aluno(id, cpf, nome, datanascimento, email, matriculado) values ("+i+", "+cpf+", '"+ nome+"', '"+datanascimento+"', '"+email+"', "+matriculando+")");
        return"cadastrar";
    }
    public static String consulta(){
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = DataBase.getConnection();
            ps = con.prepareStatement("select user, pass from userinfo where user= ? and pass=md5(?)");
        } catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
        } finally {
            DataBase.close(con);
        }
        return"";
    }
}
