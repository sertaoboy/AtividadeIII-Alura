public class Banco {
    private double saldo;
    private double limite;

    public void setSaldo(double saldo){
        this.saldo=saldo;
    }
    public void setLimite(double limite){
        this.limite=limite;
    }
    public double getSaldo(){
        return saldo;
    }
    public double getLimite(){
        return limite;
    }



    public void mostraDados(){
        System.out.println("*******************************");
        System.out.println("Saldo atual: R$"+getSaldo());
        System.out.println("*******************************");
    }
}
