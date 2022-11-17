package LpIITrabalhoFinal;

public class Funcionarios {
    private int matricula;
    private String nome;
    private String endereco;
    private String setor;
    private String login;
    private String senha;
    private String dataIngressao;

    public Funcionarios() {
    this.matricula = 0;
    this.nome = "";
    this.endereco = "";
    this.setor = "";
    this.login = "";
    this.senha = "";
    this.dataIngressao = "";
}
    
    public Funcionarios(int matricula, String nome, String endereco, String setor, String login, String senha,
            String data) {
        this.matricula = matricula;
        this.nome = nome;
        this.endereco = endereco;
        this.setor = setor;
        this.login = login;
        this.senha = senha;
        this.dataIngressao = data;
    }
    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getSetor() {
        return setor;
    }
    public void setSetor(String setor) {
        this.setor = setor;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getData() {
        return dataIngressao;
    }
    public void setData(String data) {
        this.dataIngressao = data;
    }

    @Override
    public String toString() {
        return  matricula + ";" + nome + ";"  + endereco + ";"  + setor + ";"  + login + ";"  + senha + ";"  + dataIngressao  ;
    }
    
}
