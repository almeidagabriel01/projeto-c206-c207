public class Main {
    public static void main(String[] args) {
        BrownieCafe bc = new BrownieCafe("BrownieCafé", 100, "CaféEspecial");
        BrownieDoceDeLeite bdl = new BrownieDoceDeLeite("BrownieDoceDeLeite", 75, "DoceDeLeite");
        BrownieNutella bn = new BrownieNutella("BrownieNutella", 90, "Nutella");

        bc.addCarrinhoDeCompras();
        bc.calculaValorTotalCompra();
        bc.adicionaCafe();
        bc.mostraInfo();

        bdl.addCarrinhoDeCompras();
        bdl.calculaValorTotalCompra();
        bdl.adicionaDoceDeLeite();
        bdl.mostraInfo();

        bn.addCarrinhoDeCompras();
        bn.calculaValorTotalCompra();
        bn.adicionaNutella();
        bn.mostraInfo();
    }
}
