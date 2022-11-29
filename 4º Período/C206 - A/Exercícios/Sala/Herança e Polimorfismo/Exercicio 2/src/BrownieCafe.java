public class BrownieCafe extends Brownie {
  public BrownieCafe(String nome, double preco, String sabor) {
    super(nome, preco, sabor);
  }

  public void adicionaCafe(){
    System.out.println("Adicionando mais café...");
  }

  @Override
  public void addCarrinhoDeCompras(){
    System.out.println("Adicionando um " + this.nome + " no carrinho de compras");
  }
}
