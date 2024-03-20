import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Menu {
    private int opcao;
    ArrayList<Produtos> produtosComprados = new ArrayList<>();

    public Menu (){
    }
    public void setOpcao(int opcao){
        this.opcao = opcao;
    }
    public int getOpcao(){
        return opcao;
    }

    public void inicializa(){
        Banco banco1 = new Banco();
        Scanner leitura = new Scanner(System.in);

        System.out.println("Digite o limite do cartao: ");
        banco1.setLimite(leitura.nextDouble());
        banco1.setSaldo(banco1.getLimite());

        do {
            Produtos produto1 = new Produtos();
            leitura.nextLine();
            System.out.println("Qual produto deseja comprar? ");
            produto1.setNome(leitura.nextLine());
            System.out.println("Digite o valor da compra: ");
            produto1.setPreco(leitura.nextDouble());

            if(produto1.getPreco() > banco1.getLimite()){
                System.out.println("Limite insuficiente. Encerrando...");
                System.out.println("Compra(s) realizada(s): ");
                Collections.sort(produtosComprados, new Comparator<Produtos>() {
                    @Override
                    public int compare(Produtos p1, Produtos p2) {
                        return Double.compare(p1.getPreco(), p2.getPreco());
                    }
                });
                for (Produtos produto : produtosComprados) {
                    System.out.println(produto.getNome() + " - " + produto.getPreco());
                }
                banco1.mostraDados();
                break;
            }else{
                produtosComprados.add(produto1);
                System.out.println("Compra(s) realizada(s): ");
                System.out.println(produto1.getNome() + " - " + produto1.getPreco());
                banco1.setSaldo(banco1.getSaldo() - produto1.getPreco());
                banco1.mostraDados();
                System.out.println("Deseja continuar comprando? 1 para sim, 0 para nao: ");
                setOpcao(leitura.nextInt());

                if(getOpcao()==0){
                    System.out.println("Compra(s) realizada(s): ");
                    Collections.sort(produtosComprados, new Comparator<Produtos>() {
                        @Override
                        public int compare(Produtos p1, Produtos p2) {
                            return Double.compare(p1.getPreco(), p2.getPreco());
                        }
                    });
                    for (Produtos produto : produtosComprados) {
                        System.out.println(produto.getNome() + " - " + produto.getPreco());
                    }
                    banco1.mostraDados();
                    break;
                }
            }
        } while(true);
    }
}