public class BrownieDoceDeLeite extends Brownie {
  public BrownieDoceDeLeite(String nome, double preco, String sabor) {
    super(nome, preco, sabor);
  }

  public void adicionaDoceDeLeite(){
    System.out.println("Adicionando mais doce de leite...");
  }

  @Override
  public void addCarrinhoDeCompras(){
    System.out.println("Adicionando um " + this.nome + " no carrinho de compras");
  }
}