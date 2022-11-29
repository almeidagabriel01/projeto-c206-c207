package br.inatel.cdg.classes;

import br.inatel.cdg.exceptions.CandidatoInválidoChecked;

public abstract class Candidatos {
    private String nome;
    private int numero;
    private String frase;
    private int votos = 0;

    public Candidatos(String nome, int numero, String frase) {
        this.nome = nome;
        this.numero = numero;
        this.frase = frase;
    }

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

    public void quantVotos(){
        votos++;
    }

    public String getVotos() {
        return "O candidato " + nome + " recebeu " + votos + " votos.";
    }
}
