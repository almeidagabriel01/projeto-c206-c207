import java.util.*;

public class Empresa {
  private String nome;
  private String cnpj;
  private int totalFuncionarios;
  private int totalDepartamentos;

  private ArrayList<Departamento> departamentos;

  private ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

  public Empresa(String nome, String cnpj) {
    this.nome = nome;
    this.cnpj = cnpj;
  }

  public void addFuncionario(Funcionario funcionario) {
    funcionarios.add(funcionario);
    totalFuncionarios = funcionarios.size();
  }

  public void addDepartamento(String nome, double orcamento) {
    Departamento departamento = new Departamento(nome, orcamento);
    departamentos.add(departamento);
    totalDepartamentos = departamentos.size();
  }

  public void mostrarInformacoes() {
    System.out.println("Empresa: " + nome);
    System.out.println("CNPJ: " + cnpj);
    System.out.println("Total de funcionários: " + totalFuncionarios);
    System.out.println("Total de departamentos: " + totalDepartamentos);
  }

  public void listarFuncionarios() {
    for (Funcionario funcionario : funcionarios) {
      funcionario.mostrarInformacoes();
    }
  }

  public void listarDepartamentos() {
    for (Departamento departamento : departamentos) {
      departamento.mostrarInformacoes();
    }
  }
  
  public String getNome() {
    return nome;
  }
}
