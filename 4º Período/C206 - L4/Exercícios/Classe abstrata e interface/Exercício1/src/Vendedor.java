public class Vendedor extends Usuário implements Funcionário {
  public Vendedor(String nome, String cpf, int idade) {
    super(nome, cpf, idade);
  }

  @Override
  public void receberSalário() {
    // Vendedor recebe 1 salário mínimo
    // Salário mínimo: R$ 1.212,00
    System.out.println(nome + " recebe R$" + 1212.00);
  }
}
