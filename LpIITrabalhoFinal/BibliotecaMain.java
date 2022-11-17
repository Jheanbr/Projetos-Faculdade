package LpIITrabalhoFinal;
import java.util.Scanner;


import LpIITrabalhoFinal.controles.AlunosControler;
import LpIITrabalhoFinal.controles.FuncionariosControler;

public class BibliotecaMain {

    static StringBuffer memoria = new StringBuffer();
    static Scanner scan = new Scanner (System.in);
    static AlunosControler alunosControler = new AlunosControler();
    
    static FuncionariosControler funcionariosControler = new FuncionariosControler();
    static Funcionarios funcionarios = new Funcionarios();
    static Alunos alunos = new Alunos();
    
        public static void main(String[] args) throws Exception {
            
            System.out.println(FuncionariosControler.caminhoFuncionarios);
            System.out.println("Bem vindo ao sistema da biblioteca!");
            System.out.println("Faça login com seu usuario de funcionario e senha para entrar:");
            System.out.println("LOGIN:");
            String login = scan.next();
            while (!FuncionariosControler.login(login)){
                System.out.println("Insira um usuario valido!");
                login = scan.next();
                FuncionariosControler.login(login);
            }

            int opcao;
         do {
                 System.out.println("Digite 1 para Gerenciar alunos\n"
                             +"Digite 2 para gerenciar Funcionarios\n"
                             +"Digite 3 gerenciar Professores"
                             +"Digite 4 para Depositar\n"
                             +"Digite 5 para Sair\n"
                             );
                            opcao = scan.nextInt();
                switch(opcao){
                    case 1:
                        int opcaoUsu= -1;
                        while (opcaoUsu != 5){
                        System.out.println("Digite 1 para Adicionar alunos\n"
                             +"Digite 2 para editar alunos\n"
                             +"Digite 3 gerar relatorio de todos os alunos\n"
                             +"Digite 4 para excluir alunos\n"
                             +"Digite 5 para voltar"
                             
                             );
                            opcaoUsu = scan.nextInt();
                            switch(opcaoUsu){
                                case 1 :
                                AlunosControler.inserirDadosAluno();
                                break;
                                case 2 :
                                AlunosControler.alterarDadosAluno();
                                break;
                                case 3 :
                                AlunosControler.relatorioAluno();
                                break;
                                case 4 :
                                AlunosControler.excluirDadosAluno();
                                case 5 :
                                break;
                                default:
                                break;
                            }}
                    
                    break;
                    case 2:
                    
                    int opcaoFun= -1;
                    while (opcaoFun != 5){
                    System.out.println("Digite 1 para Adicionar Funcionarios\n"
                         +"Digite 2 para editar Funcionarios\n"
                         +"Digite 3 gerar relatorio de todos os Funcionarios\n"
                         +"Digite 4 para excluir Funcionarios\n"
                         +"Digite 5 para voltar"
                         
                         );
                        opcaoUsu = scan.nextInt();
                        switch(opcaoUsu){
                            case 1 :
                            FuncionariosControler.inserirDadosFuncionarios();
                            break;
                            case 2 :
                            FuncionariosControler.alterarDadosFuncionarios();
                            break;
                            case 3 :
                            FuncionariosControler.relatorioFuncionarios();
                            break;
                            case 4 :
                            FuncionariosControler.excluirDadosFuncionarios();
                            case 5 :
                            break;

                            default:
                            break;
                        }}
                
                    break;
                    case 3:       
                        //controlador de livros e periodicos
                        int opcaoliePe= -1;
                        while (opcaoliePe != 5){
                        System.out.println("Digite 1 para Adicionar Livros\n"
                             +"Digite 2 para editar alunos\n"
                             +"Digite 3 gerar relatorio de todos os alunos\n"
                             +"Digite 4 para excluir alunos\n"
                             +"Digite 5 para voltar"
                             
                             );
                            opcaoUsu = scan.nextInt();
                            switch(opcaoUsu){
                                case 1 :
                                AlunosControler.inserirDadosAluno();
                                break;
                                case 2 :
                                AlunosControler.alterarDadosAluno();
                                break;
                                case 3 :
                                AlunosControler.relatorioAluno();
                                break;
                                case 4 :
                                AlunosControler.excluirDadosAluno();
                                case 5 :
                                break;
                                default:
                                break;
                            }}
                    
                    break;
                    case 4:
                        //controlador de emprestimos
                    break;
                                               
                    default: break;
    
                }
    
            }while(opcao !=5);
    
        }

     

}
