public class Main {
    public static void main(String[] args) throws Exception {
        Zumbi zumbi1 = new Zumbi();
        Zumbi zumbi2 = new Zumbi();
        
        zumbi1.nome = "Zumbi 1";
        zumbi2.nome = "Zumbi 2";
        zumbi1.vida = 100;
        zumbi2.vida = 100;
        
        zumbi1.transfereVida(zumbi2, 50);
        System.out.println(zumbi1.nome + " " + zumbi1.vida);
        System.out.println(zumbi2.nome + " " + zumbi2.vida);

        zumbi1 = zumbi2;
        
        zumbi1.transfereVida(zumbi2, 30);
        System.out.println(zumbi1.nome + " " + zumbi1.vida);
        System.out.println(zumbi2.nome + " " + zumbi2.vida);
    }
}
