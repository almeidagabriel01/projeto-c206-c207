public abstract class Usuário {
  protected String nome;
  protected String cpf;
  protected int idade;

  public Usuário(String nome, String cpf, int idade) {
    this.nome = nome;
    this.cpf = cpf;
    this.idade = idade;
  }

  public void mostraInfos(){
    System.out.println("Nome: " + nome);
    System.out.println("CPF: " + cpf);
    System.out.println("Idade: " + idade);
  }
}
