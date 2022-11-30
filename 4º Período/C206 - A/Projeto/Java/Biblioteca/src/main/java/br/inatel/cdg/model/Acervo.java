package br.inatel.cdg.model;

public abstract class Acervo {
    private int idAcervo;
    private String titulo;
    private String CDU;

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
