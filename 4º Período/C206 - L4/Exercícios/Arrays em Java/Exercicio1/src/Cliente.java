public class Cliente {
  String nome;

  public Cliente(String nome) {
    this.nome = nome;
  }

  void contratarServico(Empresa empresa) {
    /*
     Na ASSOCIAÇÃO, não há regra bem definida para como devemos implementar uma funcionalidade...
     
     Aqui, por exemplo, o cliente contrata o serviço de uma empresa através da passagem de um objeto do tipo Empresa por referência em uma função.
     */
    System.out.println(nome + " contratou a empresa " + empresa.nome + ".");
  }
}
