package musica;

public class Faixa {

    private String titulo;

    private String autor;

    private int duracao;

    public Faixa(String titulo, String autor, int duracao) {
        this.titulo = titulo;
        this.autor = autor;
        this.duracao = duracao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getDuracao() {
        return duracao;
    }
}
