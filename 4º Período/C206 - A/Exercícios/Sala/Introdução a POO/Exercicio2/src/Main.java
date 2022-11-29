public class Main {
    public static void main(String[] args) throws Exception {
        Zumbi zumbi1 = new Zumbi();
        Zumbi zumbi2 = new Zumbi();
        
        zumbi1.nome = "Zumbi 1";
        zumbi2.nome = "Zumbi 2";
        zumbi1.vida = 100;
        zumbi2.vida = 100;
        
        zumbi1.transfereVida(zumbi2, 50);
        System.out.println("Zumbi 1 tem a vida: " + zumbi1.mostraVida());
        System.out.println("Zumbi 2 tem a vida: " + zumbi2.mostraVida());
    }
}
