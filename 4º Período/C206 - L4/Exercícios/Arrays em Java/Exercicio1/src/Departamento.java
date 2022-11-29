public class Departamento {
  String nome;
  double orcamento;

  public Departamento(String nome, double orcamento) {
    this.nome = nome;
    this.orcamento = orcamento;
  }

  void mostrarInformacoes() {
    System.out.println("Departamento: " + nome);
    System.out.println("Orcamento: R$" + orcamento);
  }
}
