package LpIITrabalhoFinal;

public class Livros {
    private int codigo;
    private String autor;
    private String titulo;
    private String editora;
    private String issn;
    private char tipo;
    private int anoPublicacao;
    
    
    public Livros(int codigo, String autor, String titulo, String editora, String issn, char tipo, int anoPublicacao) {
        this.codigo = codigo;
        this.autor = autor;
        this.titulo = titulo;
        this.editora = editora;
        this.issn = issn;
        this.tipo = tipo;
        this.anoPublicacao = anoPublicacao;
    }
    
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getEditora() {
        return editora;
    }
    public void setEditora(String editora) {
        this.editora = editora;
    }
    public String getIssn() {
        return issn;
    }
    public void setIssn(String issn) {
        this.issn = issn;
    }
    public char getTipo() {
        return tipo;
    }
    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    public int getAnoPublicacao() {
        return anoPublicacao;
    }
    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
    @Override
    public String toString() {
        return  codigo + ";" + autor +  ";" + titulo +  ";"  + editora +  ";"  + issn +  ";"  + tipo +  ";"  + anoPublicacao ;
    }
    
}
