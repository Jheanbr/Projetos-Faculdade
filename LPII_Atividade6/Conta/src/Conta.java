public class Conta {
   private int numeroConta;
   private String titular;
   private double saldo;

    public Conta() {
        this.numeroConta =0;
        this.titular= "";
        this.saldo=0;
    }
    public Conta(int numeroConta, String titular, double saldo){
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }
    public int getNumeroConta() {
        return this.numeroConta;
    }
    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }
    public double getSaldo() {
        return this.saldo;
    }
    public  void setSaldo(double novo) {
        this.saldo = novo;
    }
    public String getTitular() {
        return this.titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }

    @Override
    public String toString() {
        
        return super.toString();
    }

    public boolean SacarDinheiro(double valorSacado) {
        boolean saque;

            if (saldo >=valorSacado){
                saque = true;
                
            }else{
                saque =false;
            }


        return saque;
    }
}
