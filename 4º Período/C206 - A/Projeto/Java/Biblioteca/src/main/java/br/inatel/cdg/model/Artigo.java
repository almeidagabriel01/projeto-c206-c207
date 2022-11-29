package br.inatel.cdg.model;

public class Artigo extends Acervo{
    private String autor;
    private int idArtigo;

    public Artigo(int numRegistro, String titulo, String CDU, String autor) {
        super(numRegistro, titulo, CDU);
        this.autor = autor;
    }

    public void setIdArtigo(int Id) {
        this.idArtigo = Id;
    }

    public int getId() {
        return idArtigo;
    }

    public String getAutor() {
        return autor;
    }
}
