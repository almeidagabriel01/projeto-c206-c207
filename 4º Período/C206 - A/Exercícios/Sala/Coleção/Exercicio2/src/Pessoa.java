public abstract class Pessoa implements Comparable<Pessoa> {
  private String nome;
  private int idade;

  public Pessoa(String nome, int idade) {
    this.nome = nome;
    this.idade = idade;
  }

  public void mostrarDados() {
    System.out.println("Nome: " + nome);
    System.out.println("Idade: " + idade);
  }

  @Override
  public int compareTo(Pessoa o) {
    if (this.idade < o.idade) {
      return -1;
    }
    if (this.idade > o.idade) {
      return 1;
    }
    return 0;
  }
}
