public class SistamaOperacional {
  String nome;
  int tipo;

  public SistamaOperacional(String nome, int tipo) {
    this.nome = nome;
    this.tipo = tipo;
  }

  void mostraInfo(){
    System.out.println("Sistema Operacional " + nome + " (" + tipo + " bits)");
  }
  
}
