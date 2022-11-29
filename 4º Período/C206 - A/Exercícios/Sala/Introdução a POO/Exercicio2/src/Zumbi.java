public class Zumbi {
  double vida;
  String nome;

  public double mostraVida(){
    return vida;
  }

  public void transfereVida(Zumbi alvo, double vida){
    alvo.vida += vida;
    this.vida -= vida;
  }
}
