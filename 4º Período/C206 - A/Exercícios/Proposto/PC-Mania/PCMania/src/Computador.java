public class Computador {
  String marca;
  float preco;
  MemoriaUSB memoriaUSB;

  int idPromo = 1;

  HardwareBasico[] hardwareBasico; // composição
  SistamaOperacional sistamaOperacional; // agregação

  int qtdHardwareBasico = 0;

  public Computador(String marca, float preco, int ID) {
    this.marca = marca;
    this.preco = preco;
    this.idPromo = ID;
    hardwareBasico = new HardwareBasico[3];
  }

  void addMemoriaUSB(MemoriaUSB musb) {
    memoriaUSB = musb;
  }

  void addHardwareBasico(String nome, float capacidade){
    hardwareBasico[qtdHardwareBasico] = new HardwareBasico(nome, capacidade);
    qtdHardwareBasico++;
  }

  void addSistema(String nomeSystem, int tipoSystem){
    sistamaOperacional = new SistamaOperacional(nomeSystem, tipoSystem);
  }

  void mostraPCConfigs() {
    System.out.println("Promoção " + idPromo);
    System.out.println("------------------------");

    System.out.println("Marca: " + marca + "\nPreço: R$" + preco);
    System.out.println("------------------------");
    mostraHardwareBasicos();

    System.out.println("------------------------");
    sistamaOperacional.mostraInfo();

    System.out.println("------------------------");
    memoriaUSB.mostraInfo();
    System.out.println("");
  }

  void mostraHardwareBasicos() {
    for (int i = 0; i < hardwareBasico.length; i++) {
      if(hardwareBasico[i] != null){
        hardwareBasico[i].mostraInfo();
      }
    }
  }

  void calculaPreco(Cliente cliente) {
    cliente.preco += preco;
  }
}
