package br.inatel.cdg.model;

public class Empréstimo {
    private int idEmprestimo;
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

    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public int setId(int Id) {
        this.idEmprestimo = Id;
        return Id;
    }

    public int getId() {
        return idEmprestimo;
    }
}
