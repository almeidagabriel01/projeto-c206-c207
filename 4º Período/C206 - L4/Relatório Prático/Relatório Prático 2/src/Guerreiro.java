public class Guerreiro extends PersonagemDeJogador implements AtacanteFisico {
  private String arma;

  public Guerreiro(String nome, String genero, int nivel, int vida) {
    super(nome, genero, nivel, vida);
  }

  public void setArma(String arma) {
    this.arma = arma;
  }

  public void ataqueFisico() {
    System.out.println(nome + " atacando com " + this.arma);
  }

  @Override
  public void mostrarInfo() {
    System.out.println("Nome: " + this.nome);
    System.out.println("Gênero: " + this.genero);
    System.out.println("Nível: " + this.nivel);
    System.out.println("Vida: " + this.vida);
    System.out.println("Arma: " + this.arma);
  }
}
