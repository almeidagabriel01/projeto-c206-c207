public class Twitter extends RedeSocial implements Compartilhamento{
  public Twitter(String senha, int numeroDeAmigos) {
    super(senha, numeroDeAmigos);
  }

  @Override
  public void postarFoto() {
    System.out.println("Postou foto no Twitter");
  }

  @Override
  public void postarVideo() {
    System.out.println("Postou video no Twitter");
  }

  @Override
  public void postarComentario() {
    System.out.println("Postou comentario no Twitter");
  }

  @Override
  public void compartilhar() {
    System.out.println("Compartilhou no Twitter");
  }
  
  @Override
  public void entrouNoPerfil() {
    System.out.println("Entrou no perfil do Twitter");
  }

  @Override
  public void numeroAmigos() {
    System.out.println("Numero de amigos no Twitter é: " + numAmigos);
  }
}
