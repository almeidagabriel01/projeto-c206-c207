package br.inatel.cdg.model;

public class Livro extends Acervo{
    private int idLivro;
    private String autor;
    private String editora;
    private String edição;

    public Livro(String titulo, String CDU, String autor, String editora, String edição) {
        super(titulo, CDU);
        this.autor = autor;
        this.editora = editora;
        this.edição = edição;
    }

    public void setId(int Id) {
        this.idLivro = Id;
    }

    public int getId() {
        return idLivro;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }

    public String getEdição() {
        return edição;
    }
}
