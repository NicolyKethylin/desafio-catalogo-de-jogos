public class Jogo {
    String nome;
    String categoria;
    String descricao;
    Double preco;

    public Jogo(String nome, String categoria, String descricao, Double preco){
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getNome(){
        return nome;
    }

    public String getCategoria(){
        return categoria;
    }

    public String getDescricao(){
        return descricao;
    }

    public Double getPreco(){
        return preco;
    }


}
