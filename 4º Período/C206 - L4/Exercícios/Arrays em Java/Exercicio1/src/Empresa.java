public class Empresa {
  String nome;
  String cnpj;
  int totalFuncionarios = 0;
  int totalDepartamentos = 0;

  Departamento[] departamentos; // Composição
  Funcionario[] funcionarios; // Agregação

  public Empresa(String nome, String cnpj, int maxDepartamentos, int maxFuncionarios) {
    this.nome = nome;
    this.cnpj = cnpj;
    departamentos = new Departamento[maxDepartamentos];
    funcionarios = new Funcionario[maxFuncionarios];
  }

  void mostrarInformacoes() {
    System.out.println("Empresa: " + nome);
    System.out.println("CNPJ: " + cnpj);
    System.out.println("Total de Departamentos: " + totalDepartamentos);
    System.out.println("Total de Funcionarios: " + totalFuncionarios);
  }

  public void addDepartamento(String nome, double orcamento) {
    // Na COMPOSIÇÃO, Departamento é criado internamente em Empresa.
    departamentos[totalDepartamentos] = new Departamento(nome, orcamento);
    totalDepartamentos += 1;
  }

  public void addFuncionario(Funcionario funcionario) {
    // Na AGREGAÇÃO, Funcionario é criado externamente. Depois, é referenciado em Empresa.
    funcionarios[totalFuncionarios] = funcionario;
    totalFuncionarios += 1;
  }

  public void listarFuncionarios() {
    for (Funcionario funcionario : funcionarios) {
      if (funcionario != null) {
        System.out.println("--- --- --- --- --- ---");
        funcionario.mostrarInformacoes();
      }
    }
  }

  public void listarDepartamentos() {
    for (Departamento departamento : departamentos) {
      if (departamento != null) {
        System.out.println("--- --- --- --- --- ---");
        departamento.mostrarInformacoes();
      }
    }
  }
}
