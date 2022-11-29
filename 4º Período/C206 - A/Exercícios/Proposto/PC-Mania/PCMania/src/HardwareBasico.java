public class HardwareBasico {
  String nome;
  float capacidade;

  public HardwareBasico(String nome, float capacidade) {
    this.nome = nome;
    this.capacidade = capacidade;
  }

  void mostraInfo() {
    if (nome.startsWith("Proce")) {
      System.out.println(nome + " (" + capacidade + " Mhz)");
    }
    else if (nome.startsWith("Mem")) {
      System.out.println(capacidade + " GB de " + nome);
    }
    else if (nome.startsWith("HD")) {
      if (capacidade >= 100) { // Se a capacidade for maior que 100 -> Mostra em Gb
        System.out.println(capacidade + "GB de " + nome);
      } else // Se não for, motra em Tb
      {
        System.out.println(capacidade + "TB de " + nome);
      }
    }
  }

}
