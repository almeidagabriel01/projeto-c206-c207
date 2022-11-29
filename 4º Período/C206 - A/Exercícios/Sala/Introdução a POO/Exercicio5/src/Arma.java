public class Arma {
  String nome;
  int poder;
  int resistencia;
  String durabilidade;

  public void mostraInfoArma(){
    System.out.println("---------------------");
    System.out.println("Nome da arma: " + nome);
    System.out.println("Poder: " + poder);
    System.out.println("Resistencia: " + resistencia);
    System.out.println("Durabilidade: " + durabilidade);
  }
}
