package beans;

import java.io.Serializable;
import javax.servlet.http.HttpSession;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "alunoBean")
@SessionScoped

public class AlunoBean implements Serializable{
     private static final long serialVersionUID = 1L;
     private Integer codigo;
     private Integer CPF;
     private String nome;
     private String endereco;
     private String estado;
     private Integer periodo;
     private boolean matriculado;

    public Integer getCodigo() {return codigo;}
    public void setCodigo(Integer codigo) {this.codigo = codigo;}
    public Integer getCPF() {return CPF;}
    public void setCPF(Integer CPF) {this.CPF = CPF;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getEndereco() {return endereco;}
    public void setEndereco(String endereco) {this.endereco = endereco;}
    public String getEstado() {return estado;}
    public void setEstado(String estado) {this.estado = estado;}
    public Integer getPeriodo() {return periodo;}
    public void setPeriodo(Integer periodo) {this.periodo = periodo;}
    public boolean getMatriculado() {return matriculado;}
    public void setMatriculado(boolean matriculado) {this.matriculado = matriculado;}
    
    public String disciplinasCursadas(){
        HttpSession session = Util.getSession();
        return "";
    }
    public String disciplinasAcursar(){
        return "";
    }
    public String inicio(){
        HttpSession session = Util.getSession();
      session.invalidate();
      return "/login";
    }
}
