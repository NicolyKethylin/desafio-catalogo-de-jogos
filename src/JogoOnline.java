public class JogoOnline extends Jogo implements Jogando, Pagamento {

    public JogoOnline(String nome, String categoria, String descricao, Double preco){
        super(nome, categoria, descricao, preco);
    }

    @Override
    public void iniciarJogo() {
        System.out.println("Iniciando jogo On-line...");
    }

    @Override
    public void encerrarJogo() {
        System.out.println("Encerrando jogo On-line...");
    }

    @Override
    public Double calcularDesconto(){
        return getPreco() * 0.25;
    }
}
