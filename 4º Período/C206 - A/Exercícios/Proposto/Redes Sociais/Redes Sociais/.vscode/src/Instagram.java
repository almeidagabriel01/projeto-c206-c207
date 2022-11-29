public class Instagram extends RedeSocial {
  public Instagram(String senha, int numeroDeAmigos) {
    super(senha, numeroDeAmigos);
  }

  @Override
  public void postarFoto() {
    System.out.println("Postou foto no Instagram");
  }

  @Override
  public void postarVideo() {
    System.out.println("Postou video no Instagram");
  }

  @Override
  public void postarComentario() {
    System.out.println("Postou comentario no Instagram");
  }

  @Override
  public void entrouNoPerfil() {
    System.out.println("Entrou no perfil do Instagram");
  }

  @Override
  public void numeroAmigos() {
    System.out.println("Numero de amigos no Instagram é: " + numAmigos);
  }
}
