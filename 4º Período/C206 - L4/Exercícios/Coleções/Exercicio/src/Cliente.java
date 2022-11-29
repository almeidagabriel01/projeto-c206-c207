public class Cliente {
  private String nome;

  public Cliente(String nome) {
    this.nome = nome;
  }

  public void contratarEmpresa(Empresa empresa) {
    System.out.println("Cliente " + nome + " contratou a empresa " + empresa.getNome());
  }
}
