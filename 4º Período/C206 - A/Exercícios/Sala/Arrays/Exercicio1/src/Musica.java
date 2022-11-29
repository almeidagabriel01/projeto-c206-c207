public class Musica {
  private String nome;
  private double duracao;

  public Musica(String nome, double duracao){
    this.nome = nome;
    this.duracao = duracao;
  }

  //Getter e Setters
	public String getNome() {
		return nome;
	}
	public double getDuracao() {
		return duracao;
	}
}