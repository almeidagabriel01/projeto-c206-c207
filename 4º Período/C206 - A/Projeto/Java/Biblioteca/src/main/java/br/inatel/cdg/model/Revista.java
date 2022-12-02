package br.inatel.cdg.model;

import br.inatel.cdg.controller.AcervoDB;

public class Revista extends Acervo{
    private int idRevista;
    private String editora;
    private int ano;

    public Revista(String titulo, String CDU, String editora, int ano) {
        super(titulo, CDU);
        this.editora = editora;
        this.ano = ano;
        AcervoDB.insertAcervo(CDU, titulo);
    }

    public void setIdRevista(int Id) {
        this.idRevista = Id;
    }

    public int getId() {
        return idRevista;
    }
    public String getEditora() {
        return editora;
    }

    public int getAno() {
        return ano;
    }
}
