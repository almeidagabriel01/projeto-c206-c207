public class Pokemon {
  String especie;
  String apelido;
  int nivel;
  
  public Pokemon(String especie, String apelido, int nivel) {
    this.especie = especie;
    this.apelido = apelido;
    this.nivel = nivel;
  }

  void falarNome() {
    System.out.println("Meu nome é: " + especie);
  }

  void pokemonsPegos() {
    System.out.println("O Pokemon " + especie + " do nivel " + nivel + " foi capturado!");
  }
}