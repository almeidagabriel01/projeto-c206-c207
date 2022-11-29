package br.inatel.cdg.jogador;

import br.inatel.cdg.inimigo.Asteroide;

public class Nave {
  private String nome;
  private double vida;
  private String tipoTiro;

  public Nave(String nome, double vida, String tipoTiro) {
    this.nome = nome;
    this.vida = vida;
    this.tipoTiro = tipoTiro;
  }

  public String getNome() {
    return nome;
  }

  public double getVida() {
    return vida;
  }

  public String getTipoTiro() {
    return tipoTiro;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setVida(double vida) {
    this.vida = vida;
  }

  public void setTipoTiro(String tipoTiro) {
    this.tipoTiro = tipoTiro;
  }

  public void atirar(Asteroide ast){
    if(tipoTiro == "Explosivo"){
      ast.destruir(); // destroi o asteroide grande ou pequeno
    }
    else{ // tipoTiro == "Normal"
      if(ast.getTipoAsteroide() == "Grande"){ // se for um asteroide grande
        System.out.println("Não é possivel destruir com tiro normal");
      }
      else{ // se for um asteroide pequeno
        ast.destruir();
      }
    }
  }
}
