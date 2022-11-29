public class Brownie {
  protected String nome;
  protected double preco;
  protected String sabor;

  private static double valorTotal = 0;

  public Brownie(String nome, double preco, String sabor) {
    this.nome = nome;
    this.preco = preco;
    this.sabor = sabor;
  }

  public void addCarrinhoDeCompras(){
    System.out.println("Adicionando ao carrinho de compras um: " + this.nome);
  }
  public void calculaValorTotalCompra(){
    valorTotal += this.preco;
    System.out.println("Valor total: " + valorTotal);
  }
  public void mostraInfo(){
    System.out.println("Nome: " + this.nome + " Preço: " + this.preco + " Sabor: " + this.sabor);
  }

  public String getNome() {
    return nome;
  }
}
