package beans;
 
import dao.UserDAO;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
 
@ManagedBean(name = "loginBean")
@SessionScoped

public class LoginBean implements Serializable {
 
    private static final long serialVersionUID = 1L;
    private String password;
    private String message, uname;
    private String tipo;

    public String getTipo() {return tipo;}
    public void setTipo(String tipo) {this.tipo = tipo;}
    public String getMessage() {return message;}
    public void setMessage(String message) {this.message = message;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public String getUname() {return uname;}
    public void setUname(String uname) {this.uname = uname;}
    
    public String loginProject() {
        //boolean result = UserDAO.login(uname, password, tipo);
        String result = UserDAO.login(uname, password, tipo);
        //if (result) {
        if ("aluno".equals(result)) {
            // get Http Session and store username
            HttpSession session = Util.getSession();
            session.setAttribute("username", uname);
            return "aluno/home";
        } 
        if ("administrativo".equals(result)) {
            // get Http Session and store username
            HttpSession session = Util.getSession();
            session.setAttribute("username", uname);
            return "administrativo/principal";
        }
        if ("curso".equals(result)) {
            // get Http Session and store username
            HttpSession session = Util.getSession();
            session.setAttribute("username", uname);
            return "curso/home";
        }
        else {
 
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Invalid Login!",
                    "Please Try Again!"));
 
            // invalidate session, and redirect to other pages
 
            //message = "Invalid Login. Please Try Again!";
            return "/login";
        }
    }
    public String cadastrar(){
        HttpSession session = Util.getSession();
        session.setAttribute("username", uname);
        return "cadastrar";
    }
    public String salvar(){
        HttpSession session = Util.getSession();
        session.setAttribute("username", uname);
        return "";
    }
    public String inicio(){
        HttpSession session = Util.getSession();
        session.setAttribute("username", uname);
        return "principal";
    }
    public String logout() {
      HttpSession session = Util.getSession();
      session.invalidate();
      return "/login";
   }
}