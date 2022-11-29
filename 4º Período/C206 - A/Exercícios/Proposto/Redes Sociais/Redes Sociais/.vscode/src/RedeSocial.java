public abstract class RedeSocial {
  protected String senha;
  protected int numAmigos;

  public RedeSocial(String senha, int numAmigos) {
    this.senha = senha;
    this.numAmigos = numAmigos;
  }

  public abstract void postarFoto();
  public abstract void postarVideo();
  public abstract void postarComentario();
  public abstract void entrouNoPerfil();

  public void comentouFoto(){
    System.out.println("Comentou na foto");
  }

  public void curtirPublicacao() {
    System.out.println("Curtiu publicação");
  }

  public abstract void numeroAmigos();
}
