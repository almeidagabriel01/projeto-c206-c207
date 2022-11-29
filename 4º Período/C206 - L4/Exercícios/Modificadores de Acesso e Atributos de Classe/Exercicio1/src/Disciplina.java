public class Disciplina {
  private final String nome;
  private final String sigla;
  private final int cargaHoraria;
  
  public Disciplina(String nome, String sigla, int cargaHoraria) {
    this.nome = nome;
    this.sigla = sigla;
    this.cargaHoraria = cargaHoraria;
  }

  public String getNome(){
    return this.nome;
  }

  public String getSigla(){
    return this.sigla;
  }

  public int getCargaHoraria(){
    return this.cargaHoraria;
  }
}
