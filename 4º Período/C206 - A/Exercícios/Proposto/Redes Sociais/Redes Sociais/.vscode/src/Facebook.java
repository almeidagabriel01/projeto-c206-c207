public class Facebook extends RedeSocial implements VideoConferencia, Compartilhamento{

  public Facebook(String senha, int numeroDeAmigos) {
    super(senha, numeroDeAmigos);
  }

  @Override
  public void fazStreaming() {
    System.out.println("Fazendo streaming no Facebook");
  }

  @Override
  public void postarFoto() {
    System.out.println("Postou foto no Facebook");
  }

  @Override
  public void postarVideo() {
    System.out.println("Postou video no Facebook");
  }

  @Override
  public void postarComentario() {
    System.out.println("Postou comentario no Facebook");
  }

  @Override
  public void compartilhar() {
    System.out.println("Compartilhou no Facebook");
  }

  @Override
  public void entrouNoPerfil() {
    System.out.println("Entrou no perfil do Facebook");
  }

  @Override
  public void numeroAmigos() {
    System.out.println("Numero de amigos no Facebook é: " + numAmigos);
  }
}
