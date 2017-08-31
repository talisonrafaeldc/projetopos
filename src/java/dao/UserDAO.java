package dao;
import java.sql.*;
  
public class UserDAO {      
    //public static boolean login(String user, String password, String tipo) {
     public static String login(String user, String password, String tipo) {
        Connection con = null;
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        String retorno = null;
        try {
            con = DataBase.getConnection();
            ps = con.prepareStatement(
                    "select user, pass from userinfo where user= ? and pass=md5(?)");
            ps.setString(1, user);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            ps1 = con.prepareStatement("select tipo from userinfo where tipo=? and pass=md5(?)");
            ps1.setString(1, tipo);
            ps1.setString(2, password);
            ResultSet rs1 = ps1.executeQuery();
            //System.out.println(rs1.getCursorName());
            //retorno = rs1.getString(tipo);
            //System.out.println(retorno);
            
            /*if (rs.next())
            {
                System.out.println(rs.getString("user"));
                return true;
            }
            else {
                return false;
            }*/
            //System.out.println(a);
            if(rs.next()){
                if(rs1.next()){
                    String a = rs1.getString("tipo");
            //retorno = rs1.getCursorName();
            //System.out.println(retorno);
            //if(rs.next()){
            if("aluno".equals(a)){
                    retorno = "aluno";}
            if("administrativo".equals(a)){
                    retorno = "administrativo";}
            if("curso".equals(a)){
                    retorno = "curso";}
            }}
        } catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            //return false;
        } finally {
            DataBase.close(con);
        }
        return retorno;
    }
}