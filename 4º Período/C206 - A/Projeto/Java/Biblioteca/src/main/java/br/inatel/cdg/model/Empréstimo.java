package br.inatel.cdg.model;

public class Empréstimo {
    private int Conta_idConta;
    private int Acervo_idAcervo;
    private String dataEmprestimo;
    private String dataDevolucao;
    private String itens;
    private int qtdRenovado;

    public Empréstimo(String dataEmprestimo, String dataDevolucao, String itens, int qtdRenovado) {
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.itens = itens;
        this.qtdRenovado = qtdRenovado;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public String getItens() {
        return itens;
    }

    public int getQtdRenovado() {
        return qtdRenovado;
    }

    public int getidConta() {
        return Conta_idConta;
    }

    public int getidAcervo() {
        return Acervo_idAcervo;
    }
}
