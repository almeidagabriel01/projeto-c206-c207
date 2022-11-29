public class MemoriaUSB {
  String nome;
  int capacidade;

  public MemoriaUSB(String nome, int capacidade) {
    this.nome = nome;
    this.capacidade = capacidade;
  }

  void mostraInfo() {
    if (capacidade >= 16)
      System.out.println("Acompanha " + nome + " de " + capacidade + "Gb");
    else
      System.out.println("Acompanha " + nome + " " + capacidade + "Tb");
  }
}
