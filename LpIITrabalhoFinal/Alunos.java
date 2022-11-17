package LpIITrabalhoFinal;



public class Alunos {
    
    private int matricula;
    private String nome;
    private String endereco;
    private String curso;
    private double multa;
    private String dataIngressao;

    public Alunos() {
        this.matricula =  0;
        this.nome = "";
        this.endereco = "";
        this.multa = 0;
        this.dataIngressao = " ";
    }

    public Alunos(int matricula, String nome, String endereco, String curso, double multa, String dataIngressao) {
        this.matricula = matricula;
        this.nome = nome;
        this.endereco = endereco;
        this.curso = curso;
        this.multa = multa;
        this.dataIngressao = dataIngressao;
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
    public double getMulta() {
        return multa;
    }
    public void setMulta(double multa) {
        this.multa = multa;
    }
    public String getDataIngressao() {
        return dataIngressao;
    }
    public void setDataIngressao(String dataIngressao) {
        this.dataIngressao = dataIngressao;
    }

    @Override
    public String toString() {
        return  matricula + ";" + nome + ";" + endereco + "; " +curso + ";"  + multa + ";" + dataIngressao+";" ;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
