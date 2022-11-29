public class Guilda {
  private PersonagemDeJogador[] membros = new PersonagemDeJogador[5];

  public void addMembro(PersonagemDeJogador personagem) {
    for (int i = 0; i < membros.length; i++) {
      if (membros[i] == null) {
        membros[i] = personagem;
        break;
      }
    }
  }

  public void mostrarMembros() {
    for (int i = 0; i < membros.length; i++) {
      if (membros[i] != null) {
        membros[i].mostrarInfo();
        System.out.println();
      }
    }
  }
}
