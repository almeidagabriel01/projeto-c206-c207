public class Main {
    public static void main(String[] args) {
        Banda banda = new Banda("High School Musical", "Pagode");
        Empresario empresario1 = new Empresario("Seu Madruga",1000021023);

        Musica musica1 = new Musica("Só por Deus", 3.4f);
        Musica musica2 = new Musica("Meu amor por voce", 4.2f);
        Musica musica3 = new Musica("Vai se fude", 6.2f);

        Membro membro1 = new Membro("Jubiscleudo", "Vocalista");
        Membro membro2 = new Membro("Riunday","Guitarrista");
        Membro membro3 = new Membro("Motovlogs","Baixista");

        banda.setEmpresario(empresario1);

        banda.addMusicaNova(musica1);
        banda.addMusicaNova(musica2);
        banda.addMusicaNova(musica3);

        banda.addMembroNovo(membro1);
        banda.addMembroNovo(membro2);
        banda.addMembroNovo(membro3);

        banda.mostraInfo();
    }
}