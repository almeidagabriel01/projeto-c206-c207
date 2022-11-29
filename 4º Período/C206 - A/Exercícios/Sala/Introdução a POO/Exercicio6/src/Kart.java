public class Kart {
  String nome;
  Piloto piloto;
  Motor motor;

  public Kart(){
    motor = new Motor();
  }

  void pular(){
    System.out.println(nome + " esta pulando");
  }

  void soltarTurbo(){
    System.out.println(nome + " esta soltando turboo");
  }

  void fazerDrift(){
    System.out.println(nome + " esta metendo um drift King");
  }
}
