public class Professor extends Pessoa {
  private String matricula;
  private String departamento;

  public Professor(String nome, int idade, String matricula, String departamento) {
    super(nome, idade);
    this.matricula = matricula;
    this.departamento = departamento;
  }

  public String getMatricula() {
    return matricula;
  }

  public String getDepartamento() {
    return departamento;
  }
}
