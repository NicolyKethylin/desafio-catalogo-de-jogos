public class Dinheiro implements Descontavel {

    @Override
    public Double calcularDesconto(Double preco) {
        return preco * 0.03;
    }
}
