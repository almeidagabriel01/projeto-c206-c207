public class BrownieNutella extends Brownie {
  public BrownieNutella(String nome, double preco, String sabor) {
    super(nome, preco, sabor);
  }

  public void adicionaNutella(){
    System.out.println("Adicionando mais nutella...");
  }

  @Override
  public void addCarrinhoDeCompras(){
    System.out.println("Adicionando um " + this.nome + " no carrinho de compras");
  }
}
