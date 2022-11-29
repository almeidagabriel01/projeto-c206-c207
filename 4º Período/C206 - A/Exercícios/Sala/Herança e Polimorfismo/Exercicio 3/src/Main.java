public class Main {
    public static void main(String[] args) {
        Brownie bc = new BrownieCafe("BrownieCafé", 100, "CaféEspecial");
        Brownie bdl = new BrownieDoceDeLeite("BrownieDoceDeLeite", 75, "DoceDeLeite");
        Brownie bn = new BrownieNutella("BrownieNutella", 90, "Nutella");
        Comprador c = new Comprador("Gabriel", 1000);

        bc.mostraInfo();
        bc.addCarrinhoDeCompras();
        if(bc instanceof BrownieCafe){
            BrownieCafe brownieCafe = (BrownieCafe) bc;
            brownieCafe.adicionaCafe();
        }
        c.efetuarCompra(bc);
        bc.calculaValorTotalCompra();

        bdl.mostraInfo();
        bdl.addCarrinhoDeCompras();
        if(bdl instanceof BrownieDoceDeLeite){
            BrownieDoceDeLeite brownieDoceDeLeite = (BrownieDoceDeLeite) bdl;
            brownieDoceDeLeite.adicionaDoceDeLeite();
        }
        c.efetuarCompra(bdl);
        bdl.calculaValorTotalCompra();

        bn.mostraInfo();
        bn.addCarrinhoDeCompras();
        if(bn instanceof BrownieNutella){
            BrownieNutella brownieNutella = (BrownieNutella) bn;
            brownieNutella.adicionaNutella();
        }
        c.efetuarCompra(bn);
        bn.calculaValorTotalCompra();
    }
}
