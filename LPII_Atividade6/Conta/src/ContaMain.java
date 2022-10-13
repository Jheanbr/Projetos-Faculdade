import java.util.Scanner;

public class ContaMain {
    static Conta conta =new Conta();
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int opcao;
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
                    
                break;
                case 2:
                   
                break;
                case 3:       
                    Sacar();
                break;
                case 4:
                   
                break;
                                           
                default: break;

            }

        }while(opcao !=5);




    }

    public  void Sacar(double saldoAtual) {
        double valorSacado;
        double saldoAtual= Conta.getSaldo();
        System.out.println("Digite o valor a ser sacado:");
        valorSacado = scan.nextDouble();
        boolean saldo = Conta.SacarDinheiro(valorSacado);
        if(saldo){
            System.out.println("Saque efetuado com sucesso!/n");
            Conta.setSaldo(saldoAtual);
        }else{
            System.out.println("Saldo insuficiente!\n");
        }
    }
}
