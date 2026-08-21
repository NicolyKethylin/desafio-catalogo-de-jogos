void main() {
   List<Jogando> jogos = List.of(
           new JogoDigital("Minecraft", "Diversão","Desbravando e contruindo coisas atraves de blocos.",10.90),
           new JogoFisico("Deus da Guerra", "Ação", "Em busca de vingança contra os deuses do olimpo para vingar sua familia.", 34.09),
           new JogoOnline("GTA", "Aventura", "é um clássico jogo de ação e aventura em mundo aberto desenvolvido pela Rockstar Games que acompanha a jornada de Carl \"CJ\" Johnson no início dos anos 1990.", 23.09)
   );

    Descontavel formaPagamento = new Cartao();

    for (Jogando jogo : jogos) {
        jogo.iniciarJogo();

        double desconto = formaPagamento.calcularDesconto(jogo.getPreco());
        double precoFinal = jogo.getPreco() - desconto;

        System.out.println("Nome: " + jogo.getNome());
        System.out.println("Categoria: " + jogo.getCategoria());
        System.out.println("Descrição: " + jogo.getDescricao());
        System.out.printf("Preço original: R$ %.2f%n", jogo.getPreco());
        System.out.printf("Desconto: R$ %.2f%n", desconto);
        System.out.printf("Preço final: R$ %.2f%n", precoFinal);

        jogo.encerrarJogo();

        System.out.println("----------------");
    }

}
