package LpIITrabalhoFinal.controles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import LpIITrabalhoFinal.Alunos;

public class AlunosControler {
    static String caminhoAluno = "C:\\Users\\jhean\\Documents\\GitHub\\Projetos-Faculdade\\LpIITrabalhoFinal\\Arquivos\\Alunos.csv";
    static StringBuffer memoria = new StringBuffer();
    static Scanner scan = new Scanner (System.in);
    
    static void iniciarArquivo(){
        
        try(BufferedReader arquivoEntrada = new BufferedReader(new FileReader(caminhoAluno))){
       
        String linha = "";
        memoria.delete(0,memoria.length());//apaga tudo que está na variável memoria
        do {
        linha = arquivoEntrada.readLine();
        if (linha != null) {
        memoria.append (linha + "\n");
        }
        }while (linha != null);
        arquivoEntrada.close();
        } catch (FileNotFoundException erro){
        System.out.println("\nArquivo não encontrado");
        } catch (Exception e){
        System.out.println("\nErro de Leitura!");
        }
        }

        public static void gravarDados(){
   
            try(BufferedWriter arquivoSaida = new BufferedWriter(new FileWriter(caminhoAluno))){                    
            arquivoSaida.write(memoria.toString());
            arquivoSaida.flush();
            arquivoSaida.close();
            } catch (Exception e){
            System.out.println("\nErro de gravacao!");
            }
            }
        
            public static void inserirDadosAluno(){
                int matricula= 00000000;
                double multa = 0;
                String nome,endereco,dataIngressao,curso;
                
                try{
                     boolean ver = false;      
                    while (!ver){
                     System.out.println("Entre com a matrícula:");
                      String matriculaTemp =scan.next();
                    
                         if (matriculaTemp.length()==8){
                         matricula=Integer.parseInt(matriculaTemp);
                         ver = true;
                         }else{
                         System.out.println("A matrícula Precisa ter 8 números\n Digite novamente!"); 
                         }
                    }
                System.out.println("Digite o nome:");
                 nome = scan.next();
                System.out.println("Digite o Endereco:");
                 endereco = scan.next();
                 System.out.println("Digite o Curso:");
                 curso = scan.next();
                System.out.println("Digite a data de ingressao:");
                 dataIngressao = scan.next();

                Alunos reg = new Alunos(matricula, nome, endereco, curso, multa, dataIngressao);

                memoria.append(reg.toString()); //inserir uma nova linha no final
                
                gravarDados(); //grava alteração no HD
                }catch (Exception e){
                System.out.println("\nErro de gravacao");
                }
                }

             public static void alterarDadosAluno() {
                 String matricula, nome, endereco, dataIngressao,curso;
                 double multa;
                int inicio, fim, ultimo, primeiro;
                boolean achou=false;
                int procura;
                iniciarArquivo();
                System.out.println(memoria.length());
                if (memoria.length() != 0) { // não está vazia
                    System.out.println("\nDigite a matricula para alteração:");
                    procura= scan.nextInt();
                    inicio = 0; //inicio começa na posição 0

                    while ((inicio != memoria.length()) && (!achou)) {
                     ultimo = memoria.indexOf (";", inicio);
                     matricula = memoria.substring(inicio, ultimo);
                     primeiro = ultimo + 1; 
                     ultimo = memoria.indexOf (";", primeiro);
                     nome = memoria.substring(primeiro, ultimo);
                     primeiro = ultimo + 1;
                     ultimo = memoria.indexOf (";", primeiro);
                     endereco = memoria.substring(primeiro, ultimo);
                     primeiro = ultimo + 1; 
                     ultimo = memoria.indexOf (";", primeiro);
                     curso = memoria.substring(primeiro, ultimo);
                     primeiro = ultimo + 1; 
                     ultimo = memoria.indexOf (";", primeiro);
                     multa = Double.valueOf(memoria.substring(primeiro, ultimo));
                     primeiro = ultimo + 1; 
                     fim = memoria.indexOf ("\n", primeiro);
                     dataIngressao = memoria.substring(primeiro, fim);
                     Alunos reg = new Alunos (Integer.parseInt(matricula),nome, endereco, curso,multa, dataIngressao);

                        if (procura == reg.getMatricula()){
                            boolean alterando= false;

                            while (!alterando){
                         System.out.println("\nMatrícula: "+reg.getMatricula()+" \nNome: " +reg.getNome()+ " \nEndereco: "+reg.getEndereco()+ " \nMulta: "+reg.getMulta()+" \nData: "+reg.getDataIngressao());
                         System.out.println("\nDigite o nome do campo a ser alterado (sem acentos )");
                         System.out.println("\nDigite \"sair\" para parar de alterar campos");
 
                         String opcao = scan.next();
                            switch(opcao.toLowerCase()){

                                case "sair":
                                 alterando = true;
                                    break;
                                case "matrícula" :
                                boolean ver = false;
                                   
                               while (!ver){
                                System.out.println("Entre com nova matrícula:");
                                String matriculaTemp =scan.next();
                               
                                    if (matriculaTemp.length()==8){
                                    reg.setMatricula(Integer.parseInt(matriculaTemp));
                                    ver = true;
                                    }else{
                                    System.out.println("A matrícula Precisa ter 8 números\n"
                                    + "Digite novamente!"); 
                                    }
                                }
                                    break;
                    
                                case "nome":
                                 System.out.println("Entre com novo nome:");
                                 reg.setNome(scan.next());
                                    break;
                                case "endereco":
                                System.out.println("Entre com novo Endereço:");
                                reg.setEndereco(scan.next());
                                    break;
                                case "multa":
                                System.out.println("A multa não pode ser modificada!");
                                    break;
                                case "curso":
                                System.out.println("Entre com novo Curso:");
                                reg.setCurso(scan.next());    
                                case "data" :
                                System.out.println("digite a nova data de Ingressão no formato dd/mm/aaaa");
                                reg.setDataIngressao(scan.next());
                               }
                            }
                    
                    
                     memoria.replace(inicio, fim+1,reg.toString()); //alterar dados na memoria
                     gravarDados(); //grava alteração no HD
                     achou = true;
                    }
                    inicio = fim + 1; // continua procurando o código da pessoa
                    }
                    if (achou){ System.out.println("\nalteração realizada com sucesso");
                    }else{ System.out.println("\ncódigo não encontrado");}
                    }else{System.out.println("\narquivo vazio");
                }

                    }   
                    
                    public static void excluirDadosAluno() {
                        String matricula, nome, endereco, dataIngressao, confirmacao,curso;
                        double multa;
                        int inicio, fim, ultimo, primeiro, procura;
                        boolean achou=false;
                       
                        iniciarArquivo(); //atualizar a variavel memoria para iniciar a pesquisa
                        if (memoria.length() != 0) { // não está vazia
                        System.out.println("\nDigite a matricula do aluno para exclusão:");
                        procura= scan.nextInt();
                        inicio = 0; //inicio começa na posição 0 da variável memoria

                        //Procura o aluno em questão para excluir
                        while ((inicio != memoria.length()) && (!achou)) {
                            ultimo = memoria.indexOf (";", inicio);
                            matricula = memoria.substring(inicio, ultimo);
                            primeiro = ultimo + 1; 
                            ultimo = memoria.indexOf (";", primeiro);
                            nome = memoria.substring(primeiro, ultimo);
                            primeiro = ultimo + 1;
                            ultimo = memoria.indexOf (";", primeiro);
                            endereco = memoria.substring(primeiro, ultimo);
                            primeiro = ultimo + 1; 
                            ultimo = memoria.indexOf (";", primeiro);
                            curso = memoria.substring(primeiro, ultimo);
                            primeiro = ultimo + 1;
                            ultimo = memoria.indexOf (";", primeiro);
                            multa = Double.valueOf(memoria.substring(primeiro, ultimo));
                            primeiro = ultimo + 1; 
                            fim = memoria.indexOf ("\n", primeiro);
                            dataIngressao = memoria.substring(primeiro, fim);
                            Alunos reg = new Alunos (Integer.parseInt(matricula),nome, endereco,curso,multa, dataIngressao);

                               if (procura == reg.getMatricula()){                                 
                                System.out.println("Deseja excluir?"+"\n"+"Digite sim ou nao"+"\n\n"+
                                "\nMatrícula: "+reg.getMatricula()+" \nNome: " +reg.getNome()+ " \nEndereco: "+reg.getEndereco()+ "\nCurso: "+reg.getCurso()+" \nMulta: "+reg.getMulta()+" \nData de Ingressão: "+reg.getDataIngressao());
                                    confirmacao = (scan.next());
                                    if (confirmacao.contains("sim")){
                                         memoria.delete (inicio, fim + 1);
                                            System.out.println("Exclusão concluida.");
                                            gravarDados();
                                }else{ 
                                System.out.println("Exclusão cancelada.");
                                }
                             achou = true;
                                }
                                inicio = fim + 1; // continua procurando o código da pessoa
                            }
                         if (!achou){ System.out.println("\ncódigo não encontrado");}
                        }else{System.out.println("\narquivo vazio");}

                    }
                    public static void relatorioAluno() {
                        String matricula, nome, endereco, dataIngressao,curso;
                        double multa;
                        int inicio=0, fim, ultimo, primeiro;    
                        iniciarArquivo(); //atualizar a variavel memoria para iniciar a pesquisa

                            System.out.println("\n Lista de Alunos registrados na biblioteca: ");

                            //Exibe todos os alunos registrados
                        while ((inicio != memoria.length())  ) {
                         ultimo = memoria.indexOf (";", inicio);
                         matricula = memoria.substring(inicio, ultimo);
                         primeiro = ultimo + 1; 
                         ultimo = memoria.indexOf (";", primeiro);
                         nome = memoria.substring(primeiro, ultimo);
                         primeiro = ultimo + 1;
                         ultimo = memoria.indexOf (";", primeiro);
                         endereco = memoria.substring(primeiro, ultimo);
                         primeiro = ultimo + 1;
                         ultimo = memoria.indexOf (";", primeiro);
                         curso = memoria.substring(primeiro, ultimo);
                         primeiro = ultimo + 1; 
                         ultimo = memoria.indexOf (";", primeiro);
                         multa = Double.valueOf(memoria.substring(primeiro, ultimo));
                         primeiro = ultimo + 1; 
                         fim = memoria.indexOf ("\n", primeiro);
                         dataIngressao = memoria.substring(primeiro, fim);
                            Alunos reg = new Alunos (Integer.parseInt(matricula),nome, endereco,curso,multa, dataIngressao);

                         System.out.println("Matrícula: "+reg.getMatricula()+" Nome: " +reg.getNome()+ " Endereco: "+reg.getEndereco()+  "curso: "+reg.getCurso()+" Multa: "+reg.getMulta()+" Data: "+reg.getDataIngressao());
                                                             
                            inicio = fim + 1; // continua procurando o código da pessoa
                            }
                    }
}