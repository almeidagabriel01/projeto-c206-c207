package br.inatel.cdg.model;

import br.inatel.cdg.controller.AcervoDB;

public class Artigo extends Acervo{
    private String autor;
    private int idArtigo;

    public Artigo(String titulo, String CDU, String autor) {
        super(titulo, CDU);
        this.autor = autor;
        AcervoDB.insertAcervo(CDU, titulo);
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
