package LpIITrabalhoFinal;

import javax.xml.crypto.Data;

public class Professores {
    private int matricula;
    private String nome;
    private String endereco;
    private String setor;
    private Data dataIngreco;

    public Professores(int matricula, String nome, String endereco, String setor, Data dataIngreco) {
        this.matricula = matricula;
        this.nome = nome;
        this.endereco = endereco;
        this.setor = setor;
        this.dataIngreco = dataIngreco;
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

    public Data getDataIngreco() {
        return dataIngreco;
    }

    public void setDataIngreco(Data dataIngreco) {
        this.dataIngreco = dataIngreco;
    }
}
