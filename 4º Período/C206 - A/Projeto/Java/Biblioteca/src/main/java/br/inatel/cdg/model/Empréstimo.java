package br.inatel.cdg.model;

import br.inatel.cdg.controller.EmpréstimoDB;

public class Empréstimo {
    private String Conta_user;
    private int Acervo_idAcervo;
    private String dataEmprestimo;
    private String dataDevolucao;
    private EmpréstimoDB empréstimo = new EmpréstimoDB();
    Usuário usuário;

    public Empréstimo(String Conta_user, int Acervo_idAcervo, String dataEmprestimo, String dataDevolucao) {
        this.Conta_user = Conta_user;
        this.Acervo_idAcervo = Acervo_idAcervo;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public String getUserConta() {
        return Conta_user;
    }

    public int getidAcervo() {
        return Acervo_idAcervo;
    }
}
