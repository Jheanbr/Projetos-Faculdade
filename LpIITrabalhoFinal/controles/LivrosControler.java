package LpIITrabalhoFinal.controles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import LpIITrabalhoFinal.Livros;

public class LivrosControler {
    
    public static String caminhoProjeto = System.getProperty("user.dir");
    public static String caminhoLivros = caminhoProjeto+"\\LpIITrabalhoFinal\\Arquivos\\Livros.csv";

    static StringBuffer memoria = new StringBuffer();
    static Scanner scan = new Scanner (System.in);
    
    static void iniciarArquivo(){
        
        try(BufferedReader arquivoEntrada = new BufferedReader(new FileReader(caminhoLivros))){
       
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
   
            try(BufferedWriter arquivoSaida = new BufferedWriter(new FileWriter(caminhoLivros))){                    
            arquivoSaida.write(memoria.toString());
            arquivoSaida.flush();
            arquivoSaida.close();
            } catch (Exception e){
            System.out.println("\nErro de gravacao!");
            }
            }

            public static void inserirDadosLivros(){
                int codigo= 00000000,anoPublicacao;
                String titulo,autor,editora,issn;
                char tipo = 'L';
                try{
                     boolean ver = false;      
                     while (!ver){
                     System.out.println("Entre com o codigo do livro:");
                      String codigoTemp =scan.next();
                    
                         if (codigoTemp.length()==8){
                         codigo=Integer.parseInt(codigoTemp);
                         ver = true;
                         }else{
                         System.out.println("A codigo Precisa ter 8 números\n Digite novamente!"); 
                         }
                     }
                 System.out.println("Digite o titulo:");
                 titulo = scan.next();
                 System.out.println("Digite o nome do autor:");
                 autor = scan.next();
                 System.out.println("Digite a editora:");
                 editora = scan.next();
                 System.out.println("Digite o issn");
                 issn = scan.next();
                 System.out.println("Digite o ano de Publicação:");
                 anoPublicacao = scan.nextInt();

                 Livros reg = new Livros(codigo, autor, titulo, editora, issn, tipo, anoPublicacao);

                 memoria.append(reg.toString()); //inserir uma nova linha no final
                 gravarDados(); //grava alteração no HD
                }catch (Exception e){
                System.out.println("\nErro de gravacao");
                }
                }

                public static void alterarDadosLivros() {
                    String codigo, autor, titulo, editora, issn, tipo, anoPublicacao;
                    
                   int inicio, fim, ultimo, primeiro;
                   boolean achou=false;
                   int procura;
                   iniciarArquivo();
                   System.out.println(memoria.length());
                   if (memoria.length() != 0) { // não está vazia
                       System.out.println("\nDigite o codigo do livro para alteração:");
                       procura= scan.nextInt();
                       inicio = 0; //inicio começa na posição 0
   
                       while ((inicio != memoria.length()) && (!achou)) {
                        ultimo = memoria.indexOf (";", inicio);
                        codigo = memoria.substring(inicio, ultimo);
                        primeiro = ultimo + 1; 
                        ultimo = memoria.indexOf (";", primeiro);
                        autor = memoria.substring(primeiro, ultimo);
                        primeiro = ultimo + 1;
                        ultimo = memoria.indexOf (";", primeiro);
                        titulo = memoria.substring(primeiro, ultimo);
                        primeiro = ultimo + 1; 
                        ultimo = memoria.indexOf (";", primeiro);
                        editora = memoria.substring(primeiro, ultimo);
                        primeiro = ultimo + 1; 
                        ultimo = memoria.indexOf (";", primeiro);
                        issn = memoria.substring(primeiro, ultimo);
                        primeiro = ultimo + 1; 
                        ultimo = memoria.indexOf (";", primeiro);
                        tipo= memoria.substring(primeiro, ultimo);
                        primeiro = ultimo + 1; 
                        fim = memoria.indexOf ("\n", primeiro);
                        anoPublicacao = memoria.substring(primeiro, fim);

                        Livros reg = new Livros(Integer.parseInt(codigo), autor, titulo, editora, issn, tipo.charAt(0) , Integer.parseInt(anoPublicacao));
   
                           if (procura == reg.getCodigo()){
                               boolean alterando= false;
   
                               while (!alterando){
                            System.out.println("\nCodigo: "+reg.getCodigo()+" \nTitulo " +reg.getTitulo()+ " \nAutor: "+reg.getAutor()+ " \nEditora: "+reg.getEditora()+" \nIssn: "+reg.getIssn()+" \nTipo: "+reg.getTipo()+ " \nAno de publicação: "+reg.getAnoPublicacao());
                            System.out.println("\nDigite o primeiro nome do campo a ser alterado (sem acentos)");
                            System.out.println("\nDigite \"sair\" para parar de alterar campos");
    
                            String opcao = scan.next();
                               switch(opcao.toLowerCase()){
   
                                   case "sair":
                                    alterando = true;
                                       break;
                                   case "codigo" :
                                   boolean ver = false;
                                      
                                  while (!ver){
                                   System.out.println("Entre com novo codigo:");
                                   String codigoTemp =scan.next();
                                  
                                       if (codigoTemp.length()==8){
                                       reg.setCodigo(Integer.parseInt(codigoTemp));
                                       ver = true;
                                       }else{
                                       System.out.println("O codigo Precisa ter 8 números\n"
                                       + "Digite novamente!"); 
                                       }
                                   }
                                       break;
                       
                                   case "titulo":
                                    System.out.println("Entre com novo Titulo:");
                                    reg.setTitulo((scan.next()));
                                       break;
                                   case "autor":
                                   System.out.println("Entre com novo autor:");
                                   reg.setAutor(scan.next());
                                       break;
                                   case "editora":
                                    reg.setEditora(scan.next());
                                       break;
                                   case "issn":
                                   System.out.println("Entre com novo Issn:");
                                   reg.setIssn(scan.next());
                                   break;   
                                   case "tipo":
                                   System.out.println("Tipo não pode ser mudado, caso não for livrom cadastre em periodicos!");
                                   break;
                                   case "ano" :
                                   System.out.println("Digite a novo ano de publicação no formato aaaa");
                                   reg.setAnoPublicacao(scan.nextInt());
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

                       public static void excluirDadosFuncionarios() {
                        String codigo, autor, titulo, editora, issn, tipo, anoPublicacao;
                        
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
                            codigo = memoria.substring(inicio, ultimo);
                            primeiro = ultimo + 1; 
                            ultimo = memoria.indexOf (";", primeiro);
                            autor = memoria.substring(primeiro, ultimo);
                            primeiro = ultimo + 1;
                            ultimo = memoria.indexOf (";", primeiro);
                            titulo = memoria.substring(primeiro, ultimo);
                            primeiro = ultimo + 1; 
                            ultimo = memoria.indexOf (";", primeiro);
                            editora = memoria.substring(primeiro, ultimo);
                            primeiro = ultimo + 1; 
                            ultimo = memoria.indexOf (";", primeiro);
                            issn = memoria.substring(primeiro, ultimo);
                            primeiro = ultimo + 1; 
                            ultimo = memoria.indexOf (";", primeiro);
                            tipo= memoria.substring(primeiro, ultimo);
                            primeiro = ultimo + 1; 
                            fim = memoria.indexOf ("\n", primeiro);
                            anoPublicacao = memoria.substring(primeiro, fim);

                            Livros reg = new Livros(Integer.parseInt(codigo), autor, titulo, editora, issn, tipo.charAt(0) , Integer.parseInt(anoPublicacao));

                               if (procura == reg.getCodigo()){                                 
                                System.out.println("Deseja excluir?"+"\n"+"Digite sim ou nao"+"\n\n");
                                System.out.println("\nCodigo: "+reg.getCodigo()+" \nTitulo " +reg.getTitulo()+ " \nAutor: "+reg.getAutor()+ " \nEditora: "+reg.getEditora()+" \nIssn: "+reg.getIssn()+" \nTipo: "+reg.getTipo()+ " \nAno de publicação: "+reg.getAnoPublicacao());
                                   String confirmacao = (scan.next());
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

                    public static void relatorioFuncionarios() {
                        String codigo, autor, titulo, editora, issn, tipo, anoPublicacao;
                        
                        int inicio=0, fim, ultimo, primeiro;    
                        iniciarArquivo(); //atualizar a variavel memoria para iniciar a pesquisa

                            System.out.println("\n Lista de Livros registrados na biblioteca: ");

                            //Exibe todos os livros registrados
                         while ((inicio != memoria.length())  ) {
                            ultimo = memoria.indexOf (";", inicio);
                            codigo = memoria.substring(inicio, ultimo);
                            primeiro = ultimo + 1; 
                            ultimo = memoria.indexOf (";", primeiro);
                            autor = memoria.substring(primeiro, ultimo);
                            primeiro = ultimo + 1;
                            ultimo = memoria.indexOf (";", primeiro);
                            titulo = memoria.substring(primeiro, ultimo);
                            primeiro = ultimo + 1; 
                            ultimo = memoria.indexOf (";", primeiro);
                            editora = memoria.substring(primeiro, ultimo);
                            primeiro = ultimo + 1; 
                            ultimo = memoria.indexOf (";", primeiro);
                            issn = memoria.substring(primeiro, ultimo);
                            primeiro = ultimo + 1; 
                            ultimo = memoria.indexOf (";", primeiro);
                            tipo= memoria.substring(primeiro, ultimo);
                            primeiro = ultimo + 1; 
                            fim = memoria.indexOf ("\n", primeiro);
                            anoPublicacao = memoria.substring(primeiro, fim);
                            Livros reg = new Livros(Integer.parseInt(codigo), autor, titulo, editora, issn, tipo.charAt(0) , Integer.parseInt(anoPublicacao));

                            System.out.println("\nCodigo: "+reg.getCodigo()+" Titulo " +reg.getTitulo()+ " Autor: "+reg.getAutor()+ " Editora: "+reg.getEditora()+" Issn: "+reg.getIssn()+" Tipo: "+reg.getTipo()+ " Ano de publicação: "+reg.getAnoPublicacao());
                                                             
                            inicio = fim + 1; 
                            }
                    }




    
        
}
