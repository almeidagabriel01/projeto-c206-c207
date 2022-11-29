public class Aluno extends Pessoa {
  private String matricula;
  private String curso;

  public Aluno(String nome, int idade, String matricula, String curso) {
    super(nome, idade);
    this.matricula = matricula;
    this.curso = curso;
  }

  public String getMatricula() {
    return matricula;
  }

  public String getCurso() {
    return curso;
  }
}
