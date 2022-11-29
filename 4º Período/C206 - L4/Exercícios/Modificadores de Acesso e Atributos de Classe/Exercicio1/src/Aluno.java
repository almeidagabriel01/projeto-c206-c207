public class Aluno {
  private final String nome;
  private String curso;
  private int periodo;
  private final int matricula;
  private Disciplina[] disciplinas;
  
  public Aluno(String nome, String curso, int periodo, int matricula) {
    this.nome = nome;
    this.curso = curso;
    this.periodo = periodo;
    this.matricula = matricula;
  }

  public String getNome(){
    return this.nome;
  }

  public String getCurso(){
    return this.curso;
  }

  public void setCurso(String curso) {
    this.curso = curso;
  }

  public int getPeriodo() {
    return periodo;
  }

  public void incrementaPeriodo(int n) {
    this.periodo += n;
  }

  public int getMatricula() {
    return matricula;
  }

  public Disciplina[] getDisciplinas() {
    return disciplinas;
  }
}
