/**
 * Classe menu que faz todas as chamadas de metodos e criaçõo de interface no terminal
 * @author Breno Lopes
 * Matrícula: 725777
 */
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Menu extends Clube {
  public static int ultimoId(int id) {
    RandomAccessFile arquivo;
    int ultimoId;
    try {
      arquivo = new RandomAccessFile("clubes.db", "rw");
      ultimoId = arquivo.readInt();
      arquivo.close();
      return ultimoId;
    } catch (IOException e) {
      System.out.println("criando novo arquivo");
      return id;
    }
  }

  // Metodo para limpar o terminal
  public static void limpatela() {
    System.out.println("\u000c");
    System.out.println("\u000c");
    System.out.println("\u000c");
    System.out.println("\u000c");
  }

  /* Metodo para imprimir o menu principal */
  public static void showMenu() {
    Menu.limpatela();
    System.out.println("+-------------------------------------------+");
    System.out.println("|        Menu de Opções                     |");
    System.out.println("+-------------------------------------------+");
    System.out.println("| Opção 1 - Criar um novo Clube             |");
    System.out.println("| Opção 2 - Mostrar os Clubes               |");
    System.out.println("| Opção 3 - Editar um Clube                 |");
    System.out.println("| Opção 4 - Remover um Clube                |");
    System.out.println("| Opção 5 - Criar uma Partida               |");
    System.out.println("| Opção 99 - Sair                           |");
    System.out.println("|-------------------------------------------|");
    System.out.println("Digite a opção desejada");
  }

  /**
   * Menu para interação do usuário para criar um clube
   * @param id é passado nesse metodo para ser incrementado, se não existir clubes salvos vai ser iniciado com 0
   */
  public static void op1(int id) {
    CRUD crud = new CRUD();
    Scanner scannerOp1 = new Scanner(System.in);
    String nome;
    String cnpj;
    String cidade;

    Menu.limpatela();
    System.out.println("+-------------------------------------------+");
    System.out.println("|        Criar um Clube                     |");
    System.out.println("+-------------------------------------------+");

    System.out.println("Aperte Enter para iniciar...");
    scannerOp1.nextLine();

    System.out.print("Digite o nome do Clube ->");
    nome = scannerOp1.nextLine();

    System.out.print("Digite o CNPJ do Clube ->");
    cnpj = scannerOp1.nextLine();

    System.out.print("Digite a cidade do Clube ->");
    cidade = scannerOp1.nextLine();

    id = ultimoId(id);
    id++;

    Clube novoClube = new Clube((byte) id, nome, cnpj, cidade, 0, 0);
    crud.C(novoClube, id);

    System.out.println("Clube criado com sucesso!!! O Id do seu clube é " + id);
    System.out.println("Aperte Enter para voltar para o menu...");
    scannerOp1.nextLine();

  }

  /**
   * metodo para chamar a lista de clubes
   * */
  public static void op2() {
    Menu.limpatela();
    Scanner scannerOp2 = new Scanner(System.in);
    System.out.println("+-------------------------------------------+");
    System.out.println("|        Lista de Clubes                    |");
    System.out.println("+-------------------------------------------+");
    CRUD crud = new CRUD();
    crud.R();
    System.out.println("Aperte Enter para voltar para o menu...");
    scannerOp2.nextLine();
  }

    /**
     * metodo para fazer o update de um clube usando o ID dele como referencia
     */
  public static void op3() {
    Menu.limpatela();
    System.out.println("+-------------------------------------------+");
    System.out.println("|        Editar um Clube                    |");
    System.out.println("+-------------------------------------------+");

    String novoNome;
    String novoCNPJ;
    String novaCidade;

    Scanner sc = new Scanner(System.in);
    CRUD crud = new CRUD();

    System.out.println("Insira o ID do Clube que deseja modificar: ");
    System.out.print("ID escolhido: ");
    int id;
    id = sc.nextInt();

    //se o clube existir fazemos  upload
    if (crud.pesquisaId(id)) {
      Menu.limpatela();
      System.out.println("+-------------------------------------------+");
      System.out.println("|        Novos dados do Clube               |");
      System.out.println("+-------------------------------------------+");
      sc.nextLine();
      System.out.print("Digite o novo nome-> ");
      novoNome = sc.nextLine();
      System.out.print("Digite o novo CNPJ-> ");
      novoCNPJ = sc.nextLine();
      System.out.print("Digite a nova Cidade-> ");
      novaCidade = sc.nextLine();

      Clube novoClube = new Clube(id, novoNome, novoCNPJ, novaCidade, 0, 0);

      if (crud.U(novoClube)) {
        System.out.println("Clube alterado");
      } else {
        System.out.println("erro");
      }
    } else {
      System.out.println("erro");
    }
    System.out.println("Aperte Enter para voltar para o menu...");
    sc.nextLine();
  }

  /**
   * Metodo para remover um Clube utilizando o ID dele
   */
  public static void op4() {
    Menu.limpatela();
    System.out.println("+-------------------------------------------+");
    System.out.println("|        Remover um Clube                   |");
    System.out.println("+-------------------------------------------+");
    CRUD crud = new CRUD();
    Scanner sc = new Scanner(System.in);

    System.out.println("Digite o ID do Clube que deseja remover");
    System.out.print("ID escolhido: ");
    int id = sc.nextByte();
    if (crud.D(id) != false) { //verificacao
      System.out.println("Clube deletado");
    } else {
      System.out.println("erro");
    }
    System.out.println("Aperte Enter para voltar para o menu...");
    sc.nextLine();

  }

  /**
   * Metodo que pega o nome de dois times e a quantidade de gol dos dois times
   */
  public static void op5() {
    Menu.limpatela();
    System.out.println("+-------------------------------------------+");
    System.out.println("|        Criar uma Partida                  |");
    System.out.println("+-------------------------------------------+");

    CRUD crud = new CRUD();
    Scanner sc = new Scanner(System.in);

    String nomeClube1;
    String nomeClube2;
    int golsClube1;
    int golsClube2;

    sc.nextLine();

    System.out.println("Digite o nome primeiro Clube-> ");
    nomeClube1 = sc.nextLine();
    System.out.print("Digite a quantidade de gols do primeiro Clube-> ");
    golsClube1 = sc.nextInt();

    sc.nextLine();
    System.out.println("Digite o nome segundo Clube-> ");
    nomeClube2 = sc.nextLine();
    System.out.print("Digite a quantidade de gols do segundo Clube-> ");
    golsClube2 = sc.nextInt();

    if (crud.pesquisaNome(nomeClube1) != null && crud.pesquisaNome(nomeClube2) != null) { //verificacao
      crud.criarPartida(nomeClube1, nomeClube2, golsClube1, golsClube2); 
    } else {
      System.out.println("erro");
    }
  }

}
