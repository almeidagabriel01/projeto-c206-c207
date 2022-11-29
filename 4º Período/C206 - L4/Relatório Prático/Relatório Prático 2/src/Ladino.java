public class Ladino extends PersonagemDeJogador implements AtacanteFisico{
  private int alcanceArco;
  private int numFlechas;

  public Ladino(String nome, String genero, int nivel, int vida) {
    super(nome, genero, nivel, vida);
  }

  public void addMunicao(int qtd) {
    this.numFlechas += qtd;
    System.out.println(nome + " recebeu " + qtd + " flechas. Agora possui " + this.numFlechas + " flechas");
  }

  public void ataqueFisico() {
    numFlechas--; // Ao atacar, o ladino perde uma flecha
    while(numFlechas >= 0) {
      if(numFlechas == 0) {
        System.out.println(nome + " sem flechas");
        break;
      }
      else{
        System.out.println(nome + " atacando com flechas. Resta(m) " + this.numFlechas + " flechas");
        numFlechas--;
      }
    }
  }

  public void setAlcanceArco(int alcanceArco) {
    this.alcanceArco = alcanceArco;
  }
  
  public void setNumFlechas(int numFlechas) {
    this.numFlechas = numFlechas;
  }

  @Override
  public void mostrarInfo() {
    System.out.println("Nome: " + this.nome);
    System.out.println("Gênero: " + this.genero);
    System.out.println("Nível: " + this.nivel);
    System.out.println("Vida: " + this.vida);
    System.out.println("Alcance do arco: " + this.alcanceArco);
    System.out.println("Número de flechas: " + this.numFlechas);
  }
}
