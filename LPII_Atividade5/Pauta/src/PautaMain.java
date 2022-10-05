import java.util.Scanner;

public class PautaMain {
    static Scanner scan = new Scanner(System.in);
    static Pauta aluno = new Pauta();
    static public  void main(String[] args) throws Exception {
        int opcao;
        do {
       System.out.println("Digite 1 para Cadastrar um aluno\n"
                         +"Digite 2 para Mostrar todos os dados do aluno\n"
                         +"Digite 3 para Verificar se o aluno está reprovado por falta\n"
                         +"Digite 4 para Mostrar a média do aluno\n"
                         +"Digite 5 para Mostrar situação do aluno\n"
                         +"Digite 6 para Sair\n"
                         );
                        opcao = scan.nextInt();
            switch(opcao){
                case 1:
                    CadastrarAluno();
                break;
                case 2:
                    System.out.println(aluno.toString()+"\n");
                break;
                case 3:       
                    System.out.println("No quesito faltas, o aluno "
                    +aluno.nomeAluno+" está: "
                    + VerificarFaltas()+"!\n");
                break;
                case 4:
                    System.out.println("A média do aluno "+aluno.nomeAluno+" é "+mediaAluno()+"\n");
                break;
                case 5:
                mostrarSituacao();             
                default: break;

            }

        }while(opcao !=6);
    }

    static public void CadastrarAluno() {      
        System.out.println("Digite a matrícula do Aluno");
        int matricula =scan.nextInt();
        aluno.setMatricula(matricula);
        System.out.println("Digite o nome do Aluno");
        String nome=scan.next();
        aluno.setNomeAluno(nome);
        System.out.println("Digite o numero de faltas do Aluno");
        int falta =scan.nextInt();
        aluno.setNumFalta(falta);
        System.out.println("Digite a 1° nota do Aluno");
        int nota1 =scan.nextInt();
        aluno.setNota1(nota1);
        System.out.println("Digite a 2 ° nota do Aluno");
        int nota2 =scan.nextInt();
        aluno.setNota2(nota2);      
    }

    static public String VerificarFaltas(){
        int faltas = aluno.getNumFalta();
        String aprovado; 
        if (faltas <= 25){
         aprovado = "aprovado";
        }else{
            aprovado = "reprovado";
        }
        return aprovado;
    }

    static public double mediaAluno(){
        return (aluno.nota1+aluno.nota2)/2 ;
    }

    static public void mostrarSituacao(){
        String situacao;
        if ((mediaAluno()>=7)&&(VerificarFaltas().equals("aprovado"))){
            situacao = "aprovado";
        }else{
            situacao = "reprovado";
         } 
         System.out.println("O aluno "+aluno.nomeAluno+
         " está "+situacao+" com média de "+mediaAluno()+
         ", tem   "+ aluno.numFalta+ 
         " faltas de um possível de 25 (25% da carga horária)");
        }
           
           
    
}
