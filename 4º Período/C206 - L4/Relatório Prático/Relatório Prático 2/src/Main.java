public class Main {
    public static void main(String[] args) throws Exception {
        PersonagemDeJogador[] personagens = new PersonagemDeJogador[3];
        personagens[0] = new Ladino("Ladino", "Masculino", 10, 100);
        personagens[1] = new Mago("Mago", "Masculino", 23, 100);
        personagens[2] = new Guerreiro("Guerreiro", "Masculino", 8, 100);

        Guilda guilda = new Guilda();
        guilda.addMembro(personagens[0]);
        guilda.addMembro(personagens[1]);
        guilda.addMembro(personagens[2]);

        for(PersonagemDeJogador personagem : personagens){
            if(personagem instanceof Ladino){
                ((Ladino) personagem).setAlcanceArco(10);
                ((Ladino) personagem).setNumFlechas(10);
            }
            else if(personagem instanceof Mago){
                ((Mago) personagem).setMana(10);
                ((Mago) personagem).setEspecialidadeElemental("Fogo");
            }
            else if(personagem instanceof Guerreiro){
                ((Guerreiro) personagem).setArma("Espada");
            }
        }

        guilda.mostrarMembros();
        System.out.println();
        
        for (PersonagemDeJogador personagem : personagens) {
            if (personagem instanceof Ladino) {
                ((Ladino) personagem).ataqueFisico();
                ((Ladino) personagem).addMunicao(10);
                ((Ladino) personagem).ataqueFisico();
                System.out.println();
            } else if (personagem instanceof Mago) {
                ((Mago) personagem).recuperaMana(10);
                ((Mago) personagem).ataqueMagico();
                System.out.println();
            } else if (personagem instanceof Guerreiro) {
                ((Guerreiro) personagem).ataqueFisico();
            }
        }

    }
}
