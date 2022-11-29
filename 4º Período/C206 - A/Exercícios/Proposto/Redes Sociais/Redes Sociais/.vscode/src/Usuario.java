public class Usuario {
  private String nome;
  private String email;

  public Usuario(RedeSocial[] redesSociais, String nome, String email) {
    this.nome = nome;
    this.email = email;
    redesSociais = new RedeSocial[4];
  }

  public void MostraMetodos(RedeSocial[] redesSociais) {
    for (int i = 0; i < redesSociais.length; i++) {

      if (i % 2 == 0) {
        redesSociais[i].postarFoto();
        redesSociais[i].postarVideo();
        redesSociais[i].curtirPublicacao();
      }else{
        redesSociais[i].entrouNoPerfil();
        redesSociais[i].postarComentario();
        redesSociais[i].comentouFoto();
      }

      if(redesSociais[i] instanceof Compartilhamento){
        ((Compartilhamento) redesSociais[i]).compartilhar();
      }
      if(redesSociais[i] instanceof VideoConferencia){
        ((VideoConferencia) redesSociais[i]).fazStreaming();
      }

      redesSociais[i].numeroAmigos();
    }
  }

  public void getNome() {
    System.out.print(this.nome);
  }

  public void getEmail() {
    System.out.print(this.email);
  }

  public void mostraInfo(RedeSocial[] redesSociais) {
    System.out.print("O usuário " + this.nome);
    System.out.print(" com email " + this.email);
    System.out.println(" realizou as seguintes ações: ");
    MostraMetodos(redesSociais);
  }
}