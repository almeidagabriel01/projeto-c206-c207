public class Zumbi {
  double vida;
  String nome;

  public double mostraVida(){
    return vida;
  }

  public void transfereVida(Zumbi alvo, double vidaAlvo){
    if(this.vida > vidaAlvo){
      this.vida -= vidaAlvo;
      alvo.vida += vidaAlvo;
    }
  }
}
