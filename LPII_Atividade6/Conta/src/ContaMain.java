
import java.util.Scanner;

public class ContaMain {
   
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        
        Conta conta = new Conta();int opcao;

        do {
       System.out.println("Digite 1 para Cadastrar uma conta de cliente\n"
                         +"Digite 2 para Mostrar Saldo da conta\n"
                         +"Digite 3 para Sacar dinheiro\n"
                         +"Digite 4 para Depositar\n"
                         +"Digite 5 para Sair\n"
                         );
                        opcao = scan.nextInt();
            switch(opcao){
                case 1:
                cadastrarConta();
                break;
                case 2:
                System.out.println("O saldo da conta é:"+conta.getSaldo());
                break;
                case 3:       
                    sacar(conta.getSaldo());
                break;
                case 4:
                   conta.depositarDinheiro();
                break;
                                           
                default: break;

            }

        }while(opcao !=5);


    }

     public static void sacar(double saldoAtual) {
        Conta conta = new Conta();
        double valorSacado;
        System.out.println("Digite o valor a ser sacado:");
        valorSacado = scan.nextDouble();      
        if(conta.sacarDinheiro(valorSacado)){
            System.out.println("Saque efetuado com sucesso!/n");
            conta.setSaldo(saldoAtual-valorSacado);
        }else{
            System.out.println("Saldo insuficiente!\n");
        }
    }
    public static void cadastrarConta(){
        Conta conta = new Conta();
        System.out.println("Digite o nome do titular da conta");
        conta.setTitular(scan.next());
        System.out.println("Digite o numero da conta: ");
        conta.setNumeroConta(scan.nextInt());
    }
    
    
}
