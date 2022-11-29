public class Banda {
  private String nome;
  private String genero;
  private Membro[] membros = new Membro[5];
  private Empresario empresario;
  private Musica[] musicas = new Musica[5];

  public Banda(String nome, String genero){
    this.nome = nome;
    this.genero = genero;
  }

  void mostraInfo(){
    System.out.println("A Banda: " + this.nome + " possui os seguintes membros:");
    for (Membro membro : membros){
      if(membro != null){
        System.out.println(membro.getNome() + " sua funcao eh " + membro.getFuncao());
      }
    }

    System.out.println("A Banda: " + this.nome + " possui as seguintes musicas:");
    for (Musica musica : musicas){
      if(musica != null){
        System.out.println(musica.getNome() + " tem a duracao de " + musica.getDuracao());
      }
    }
  }

  void addMusicaNova(Musica musica){
    for(int i = 0; i < musicas.length; i++){
      if(musicas[i] == null){
        musicas[i] = musica;
        break;
      }
    }
  }

  void addMembroNovo(Membro membro){
    for(int i = 0; i < membros.length; i++){
      if(membros[i] == null){
        membros[i] = membro;
        break;
      }
    }
  }

  void setEmpresario(Empresario empresario){
    this.empresario = empresario;
  }
}
