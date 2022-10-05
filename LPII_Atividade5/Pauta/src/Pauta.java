public class Pauta {
    int matricula;
    String nomeAluno;
    int numFalta;
    double nota1;
    double nota2;

    public Pauta(){
        this.matricula = 0;
        this.nomeAluno = "";
        this.numFalta= 0;
        this.nota1= 0;
        this.nota2= 0;
    }

    public Pauta (int matricula,String nomeAluno, int numFalta, double nota1, double nota2){
        this.matricula = matricula;
        this.nomeAluno = nomeAluno;
        this.numFalta= numFalta;
        this.nota1= nota1;
        this.nota2= nota2;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public double getNota1() {
        return nota1;
    }
    
    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }
    public int getNumFalta() {
        return numFalta;
    }
    public void setNumFalta(int numFalta) {
        this.numFalta = numFalta;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    @Override
    public String toString() {
        
        return "O aluno "+this.nomeAluno+", de matrícula "
        +this.matricula+", teve uma primeira nota de "
        +this.nota1+" e uma segunda de "
        +this.nota2+" e teve "+this.numFalta+" faltas.";
    }
}
