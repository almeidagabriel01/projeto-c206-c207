public class GooglePlus extends RedeSocial implements VideoConferencia, Compartilhamento{
  public GooglePlus(String senha, int numeroDeAmigos) {
    super(senha, numeroDeAmigos);
  }

  @Override
  public void fazStreaming() {
    System.out.println("Fazendo streaming no GooglePlus");
  }

  @Override
  public void postarFoto() {
    System.out.println("Postou foto no GooglePlus");
  }

  @Override
  public void postarVideo() {
    System.out.println("Postou video no GooglePlus");
  }

  @Override
  public void postarComentario() {
    System.out.println("Postou comentario no GooglePlus");
  }

  @Override
  public void compartilhar() {
    System.out.println("Compartilhou no GooglePlus");
  }
  
  @Override
  public void entrouNoPerfil() {
    System.out.println("Entrou no perfil do GooglePlus");
  }

  @Override
  public void numeroAmigos() {
    System.out.println("Numero de amigos no GooglePlus é: " + numAmigos);
  }
}
