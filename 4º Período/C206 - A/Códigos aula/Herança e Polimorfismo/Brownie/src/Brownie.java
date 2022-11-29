public class Brownie {
  protected String nome;
  protected double preco;
  protected String sabor;

  public Brownie(String nome, double preco, String sabor) {
    this.nome = nome;
    this.preco = preco;
    this.sabor = sabor;
  }

  public void addCarrinhoDeCompras(){
    System.out.println("Adicionando ao carrinho de compras um: " + this.nome);
  }
  public void calculaValorTotalCompra(){
    System.out.println("Calculando valor total da compra de um: " + this.nome + ": " + this.preco);
  }
}
