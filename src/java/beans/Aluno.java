package beans;


import dao.AlunoDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "alunocadastroBean")
@SessionScoped
public class Aluno {
    private static final long serialVersionUID = 2L;
    private Integer id;
    private Integer cpf;
    private String nome;
    private String datanascimento;
    private String login;
    private String senha;
    private String tipo;
    private String email;
    private String estado;
    private Integer periodo;
    private boolean matriculado;
    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public Integer getCpf() {return cpf;}
    public void setCpf(Integer cpf) {this.cpf = cpf;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getDatanascimento(){return datanascimento;}
    public void setDatanascimento(String datanascimento){this.datanascimento = datanascimento;}
    public String getLogin() {return login;}
    public void setLogin(String login) {this.login = login;}
    public String getSenha() {return senha;}
    public void setSenha(String senha) {this.senha = senha;}
    public String getTipo() {return tipo;}
    public void setTipo(String tipo) {this.tipo = tipo;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getEstado() {return estado;}
    public void setEstado(String estado) {this.estado = estado;}
    public Integer getPeriodo() {return periodo;}
    public void setPeriodo(Integer periodo) {this.periodo = periodo;}
    public boolean getMatriculado() {return matriculado;}
    public void setMatriculado(boolean matriculado) {this.matriculado = matriculado;}
    
    public String salvar(){
        String result = AlunoDAO.cadastrar(cpf, nome, datanascimento, login, senha, tipo, email);
        if("cadastrar".equals(result)){
            return result;
        }
        return result;
    }
}
