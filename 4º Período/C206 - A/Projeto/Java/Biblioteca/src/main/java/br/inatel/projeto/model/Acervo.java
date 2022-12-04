package br.inatel.projeto.model;

public abstract class Acervo {
    protected int idAcervo;
    protected String titulo;
    protected String CDU;

    public Acervo(String titulo, String CDU) {
        this.titulo = titulo;
        this.CDU = CDU;
    }

    public void setIdAcervo(int Id) {
        this.idAcervo = Id;
    }

    public int getId() {
        return idAcervo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCDU() {
        return CDU;
    }
}
