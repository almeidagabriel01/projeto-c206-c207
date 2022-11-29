public class Main {
    public static void main(String[] args) throws Exception {
        RedeSocial[] redesSociais1 = new RedeSocial[2];
        RedeSocial[] redesSociais2 = new RedeSocial[2];

        redesSociais1[0] = new Facebook("FacebookSenha", 100);
        redesSociais1[1] = new Instagram("InstagramSenha", 200);

        redesSociais2[0] = new Twitter("TwitterSenha", 300);
        redesSociais2[1] = new GooglePlus("GooglePlusSenha", 400);

        Usuario usuario1 = new Usuario(redesSociais1, "João", "Joaozinho@gmail.com");
        Usuario usuario2 = new Usuario(redesSociais2, "Maria", "Maria@hotmail.com");

        usuario1.mostraInfo(redesSociais1);
        System.out.println("----------------------------------------");
        usuario2.mostraInfo(redesSociais2);
    }
}