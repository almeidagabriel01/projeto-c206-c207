public class Main {
    public static void main(String[] args) throws Exception {
        Cachorro cachorro = new Cachorro("Cachorro", 5);
        Preguica preguica = new Preguica("Preguica", 10);
        Cavalo cavalo = new Cavalo("Cavalo", 15);

        cachorro.emitirSom();
        cachorro.correr();

        preguica.emitirSom();
        preguica.subirArvore();

        cavalo.emitirSom();
        cavalo.correr();
    }
}
