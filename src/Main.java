void main() {
   List<Jogando> jogos = List.of(
           new JogoDigital("Minecraft", "Diversão","Desbravando e contruindo coisas atraves de blocos.",10.90),
           new JogoFisico("Deus da Guerra", "Ação", "Em busca de vingança contra os deuses do olimpo para vingar sua familia.", 34.09),
           new JogoOnline("GTA", "Aventura", "é um clássico jogo de ação e aventura em mundo aberto desenvolvido pela Rockstar Games que acompanha a jornada de Carl \"CJ\" Johnson no início dos anos 1990.", 23.09)
   );

    for (Jogando jogo : jogos) {
        jogo.iniciarJogo();
        jogo.encerrarJogo();

        System.out.println("----------------");
    }

}
