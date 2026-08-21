public class Cartao implements Descontavel{

    @Override
    public Double calcularDesconto(Double preco) {
        return preco * 0.05;
    }
}
