public class Cliente {
  String nome;
  long cpf;

  float preco = 0;
  
  public Cliente(String nome, long cpf) {
    this.nome = nome;
    this.cpf = cpf;
  }

  float calculaTotalCompra(){
    return preco;
  }

  void comprou() {
    System.out.println("O cliente " + nome + " com o cpf " + cpf + " teve um gasto total de " + preco);
  }
}
