public class Preguica extends Animal{
  public Preguica(String nome, int idade) {
    super(nome, idade);
  }

  public void subirArvore(){
    System.out.println("A " + this.nome + " esta subindo na arvore...");
  }

  @Override
  public void emitirSom() {
    System.out.println("A " + this.nome + " esta emitindo som...");
  }
}
