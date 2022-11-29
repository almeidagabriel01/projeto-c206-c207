public class Mago extends PersonagemDeJogador implements AtacanteMagico {
  private String especialidadeElemental;
  private int mana;

  public Mago(String nome, String genero, int nivel, int vida) {
    super(nome, genero, nivel, vida);
  }

  public void recuperaMana(int qtd) {
    this.mana += qtd;
    System.out.println(nome + " recuperou " + qtd + " de mana. Agora possui " + this.mana + " de mana");
  }

  public void ataqueMagico() {
    mana--; // Ao atacar, o mago perde um ponto de mana
    while(mana >= 0) {
      if(mana == 0) {
        System.out.println(nome + " sem mana");
        break;
      }
      else{
        System.out.println(nome + " atacando com " + especialidadeElemental + ". Resta(m) " + this.mana + " de mana");
        mana--;
      }
    }
  }

  public void setMana(int mana) {
    this.mana = mana;
  }

  public void setEspecialidadeElemental(String especialidadeElemental) {
    this.especialidadeElemental = especialidadeElemental;
  }

  @Override
  public void mostrarInfo() {
    System.out.println("Nome: " + this.nome);
    System.out.println("Gênero: " + this.genero);
    System.out.println("Nível: " + this.nivel);
    System.out.println("Vida: " + this.vida);
    System.out.println("Especialidade Elemental: " + this.especialidadeElemental);
    System.out.println("Mana: " + this.mana);
  }
}
