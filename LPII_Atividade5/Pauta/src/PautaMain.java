import java.util.Scanner;

public class PautaMain {
    static Scanner scan = new Scanner(System.in);   
    static public  void main(String[] args) throws Exception {
        Pauta aluno = new Pauta();
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
                    CadastrarAluno(aluno);
                break;
                case 2:
                    System.out.println(aluno.toString()+"\n");
                break;
                case 3:       
                    System.out.println("No quesito faltas, o aluno "
                    +aluno.getNomeAluno()+" está: "
                    + VerificarFaltas(aluno)+"!\n");
                break;
                case 4:
                    System.out.println("A média do aluno "+aluno.getNomeAluno()+" é "+mediaAluno(aluno)+"\n");
                break;
                case 5:
                mostrarSituacao(aluno);             
                default: break;

            }

        }while(opcao !=6);
    }

    static public void CadastrarAluno(Pauta aluno) {      
        System.out.println("Digite a matrícula do Aluno");
        aluno.setMatricula(scan.nextInt());
        System.out.println("Digite o nome do Aluno");
        aluno.setNomeAluno(scan.next());
        System.out.println("Digite o numero de faltas do Aluno");
        aluno.setNumFalta(scan.nextInt());
        System.out.println("Digite a 1° nota do Aluno");
        aluno.setNota1(scan.nextDouble());
        System.out.println("Digite a 2 ° nota do Aluno");
        aluno.setNota2(scan.nextDouble());      
    }

    static public String VerificarFaltas(Pauta aluno){ 
        String aprovado; 
        if (aluno.getNumFalta() <= 25){
         aprovado = "aprovado";
        }else{
            aprovado = "reprovado";
        }
        return aprovado;
    }

    static public double mediaAluno(Pauta aluno){
        return (aluno.getNota1()+aluno.getNota2())/2 ;
    }

    static public void mostrarSituacao(Pauta aluno){
        String situacao;
        if ((mediaAluno(aluno)>=7)&&(VerificarFaltas(aluno).equals("aprovado"))){
            situacao = "aprovado";
        }else{
            situacao = "reprovado";
         } 
         System.out.println("O aluno "+aluno.getNomeAluno()+
         " está "+situacao+" com média de "+mediaAluno(aluno)+
         ", tem   "+ aluno.getNumFalta()+ 
         " faltas de um possível de 25 (25% da carga horária)");
        }
           
           
    
}
