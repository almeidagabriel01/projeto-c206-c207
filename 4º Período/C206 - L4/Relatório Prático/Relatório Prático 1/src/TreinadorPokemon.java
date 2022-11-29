public class TreinadorPokemon {
  String nome;
  char sexo;
  int idade;

  Pokemon[] pokemons;
  int totalPokemons = 0;

  Pokemon[] pokemonsCapturados;
  int totalPokemonsCapturados = 0;
  ContaPokedex contaPokedex;

  public TreinadorPokemon(String nome, char sexo, int idade) {
    this.nome = nome;
    this.sexo = sexo;
    this.idade = idade;
    pokemons = new Pokemon[6];
    pokemonsCapturados = new Pokemon[6];
  }

  void capturarPokemon(Pokemon pokemon){
    pokemonsCapturados[totalPokemonsCapturados] = pokemon;
    totalPokemonsCapturados++;
  }

  void todosPokemon(Pokemon pokemon) {
    pokemons[totalPokemons] = pokemon;
    totalPokemons++;
  }

  void criarContaPokedex(String nomeUsuario) {
    contaPokedex = new ContaPokedex(nomeUsuario, 100);
  }

  void nomeTodosPokemon(){
    for (int i = 0; i < totalPokemons; i++) {
      if(pokemons[i] != null){
        pokemons[i].falarNome();
      }
    }
  }

  void mostrarPokemonsPegos(){
    for (int i = 0; i < totalPokemons; i++) {
      if(pokemonsCapturados[i] != null){
        System.out.println("--- --- --- --- --- ---");
        pokemonsCapturados[i].pokemonsPegos();
      }
    }
  }

  void infoContaPokedex(){
    System.out.println("--- --- --- --- --- ---");
    contaPokedex.mostrarInfo();
  }
}
