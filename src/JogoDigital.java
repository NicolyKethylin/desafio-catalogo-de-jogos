public class JogoDigital extends Jogo implements Jogando, Pagamento {

    public JogoDigital(String nome, String categoria, String descricao, Double preco){
        super(nome, categoria, descricao, preco); // Acessando a classe pai(Jogo)
    }

    @Override
    public void iniciarJogo() {
        System.out.println("Iniciando jogo Digital...");
    }

    @Override
    public void encerrarJogo() {
        System.out.println("Encerrando jogo Digital...");
    }

    @Override
    public Double calcularDesconto(){
        return getPreco() * 0.10;
    }
}
