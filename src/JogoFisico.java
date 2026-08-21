public class JogoFisico extends Jogo implements Jogando, Pagamento {

    public JogoFisico(String nome, String categoria, String descricao, Double preco){
        super(nome, categoria, descricao, preco);
    }

    @Override
    public void iniciarJogo() {
        System.out.println("Iniciando jogo Fisico...");
    }

    @Override
    public void encerrarJogo() {
        System.out.println("Encerrando jogo Fisico...");
    }

    @Override
    public Double calcularDesconto(){
        return getPreco() * 0.15;
    }

}
