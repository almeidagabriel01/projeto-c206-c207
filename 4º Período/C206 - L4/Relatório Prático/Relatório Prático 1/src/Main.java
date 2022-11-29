import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String nomeDoTreinador;
        char sexoDoTreinador;
        int idadeDoTreinador;

        System.out.print("Digite o nome do treinador: ");
        nomeDoTreinador = ler.nextLine();
        System.out.print("Digite o sexo do treinador: ");
        sexoDoTreinador = ler.nextLine().charAt(0);
        System.out.print("Digite a idade do treinador: ");
        idadeDoTreinador = ler.nextInt();

        Pokemon pokemon1 = new Pokemon("Pikachu", "Pika", 10);
        Pokemon pokemon2 = new Pokemon("Charmander", "Char", 16);
        Pokemon pokemon3 = new Pokemon("Bulbasaur", "Bulba", 14);
        Pokemon pokemon4 = new Pokemon("Squirtle", "Squi", 15);
        Pokemon pokemon5 = new Pokemon("Caterpie", "Cate", 20);

        TreinadorPokemon treinadorPokemon = new TreinadorPokemon(nomeDoTreinador, sexoDoTreinador, idadeDoTreinador);

        treinadorPokemon.todosPokemon(pokemon1);
        treinadorPokemon.todosPokemon(pokemon2);
        treinadorPokemon.todosPokemon(pokemon3);
        treinadorPokemon.todosPokemon(pokemon4);
        treinadorPokemon.todosPokemon(pokemon5);

        treinadorPokemon.capturarPokemon(pokemon1);
        treinadorPokemon.capturarPokemon(pokemon2);
        treinadorPokemon.capturarPokemon(pokemon3);

        treinadorPokemon.criarContaPokedex(nomeDoTreinador);
        treinadorPokemon.contaPokedex.calcularProgresso();

        treinadorPokemon.nomeTodosPokemon();
        treinadorPokemon.mostrarPokemonsPegos();
        treinadorPokemon.infoContaPokedex();

        ler.close();
    }
}
