package br.inatel.cdg.model;

public abstract class Acervo {
    private int idAcervo;
    private int numRegistro;
    private String titulo;
    private String CDU;

    public Acervo(int numRegistro, String titulo, String CDU) {
        this.numRegistro = numRegistro;
        this.titulo = titulo;
        this.CDU = CDU;
    }

    public void setIdAcervo(int Id) {
        this.idAcervo = Id;
    }

    public int getId() {
        return idAcervo;
    }

    public int getNumRegistro() {
        return numRegistro;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCDU() {
        return CDU;
    }
}
