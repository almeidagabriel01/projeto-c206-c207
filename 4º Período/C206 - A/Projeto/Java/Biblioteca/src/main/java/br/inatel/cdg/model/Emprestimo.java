package br.inatel.cdg.model;

public class Emprestimo {
    public String Conta_user;
    public int Acervo_idAcervo;
    private String dataEmprestimo;
    private String dataDevolucao;

    public Emprestimo(String dataEmprestimo, String dataDevolucao) {
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}
