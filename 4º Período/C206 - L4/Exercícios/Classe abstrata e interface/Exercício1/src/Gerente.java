public class Gerente extends Usuário implements Funcionário {
  public Gerente(String nome, String cpf, int idade) {
    super(nome, cpf, idade);
  }
  
  @Override
  public void receberSalário() {
    // Gerente recebe 3 salários mínimos
    // Salário mínimo: R$ 1.212,00
    System.out.println(nome + " recebe R$" + 3 * 1212.00);
  }
}