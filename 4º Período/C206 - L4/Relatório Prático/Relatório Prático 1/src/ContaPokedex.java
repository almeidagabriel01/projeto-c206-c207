public class ContaPokedex {
  String nomeUsuario;
  int qtdPokemonRegistrados;

  double progresso;

  public ContaPokedex(String nomeUsuario, int qtdPokemonRegistrados) {
    this.nomeUsuario = nomeUsuario;
    this.qtdPokemonRegistrados = qtdPokemonRegistrados;
  }

  void calcularProgresso(){
    progresso = qtdPokemonRegistrados * 100 / 905;

    System.out.println("O progresso do usuario " + nomeUsuario + " é de " + progresso + "%");
  }

  void mostrarInfo(){
    System.out.println("O usuario " + nomeUsuario + " tem " + qtdPokemonRegistrados + " pokemons registrados");
  }
}
