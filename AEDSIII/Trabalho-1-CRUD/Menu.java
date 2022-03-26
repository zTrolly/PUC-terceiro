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
      System.out.println("Erro em ler id");
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

  // interaçãp da opção 1
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

    System.out.print("Digite o CNPJ do clube ->");
    cnpj = scannerOp1.nextLine();

    System.out.print("Digite a cidade do clube ->");
    cidade = scannerOp1.nextLine();

    id = ultimoId(id);
    id++;

    Clube novoClube = new Clube((byte) id, nome, cnpj, cidade, 0, 0);
    crud.C(novoClube, id);

    System.out.println("Clube criado com sucesso!!! O Id do seu clube é " + id);
    System.out.println("Aperte Enter para voltar para o menu...");
    scannerOp1.nextLine();

  }

  // interação da opção 2
  public static void op2() {
    Menu.limpatela();
    System.out.println("+-------------------------------------------+");
    System.out.println("|        Lista de Clubes                    |");
    System.out.println("+-------------------------------------------+");
    CRUD crud = new CRUD();
    crud.R();
  }

  // interação da opção 3
  public static void op3() {
    Menu.limpatela();
    System.out.println("+-------------------------------------------+");
    System.out.println("|        Editar um Clube                    |");
    System.out.println("+-------------------------------------------+");
    int id;
    String novoNome;
    String novoCNPJ;
    String novaCidade;
    Scanner sc = new Scanner(System.in);
    CRUD crud = new CRUD();

    System.out.println("Insira o ID do Clube que deseja modificar: ");
    System.out.print("ID escolhido: ");
    id = sc.nextInt();

    if (crud.pesquisaId(id)) {
      Menu.limpatela();
      System.out.println("+-------------------------------------------+");
      System.out.println("|        Novos dados do Clube               |");
      System.out.println("+-------------------------------------------+");
      System.out.print("Digite o novo nome-> ");
      novoNome = sc.nextLine();
      System.out.print("Digite o novo CNPJ-> ");
      novoCNPJ = sc.nextLine();
      System.out.print("Digite a nova Cidade-> ");
      novaCidade = sc.nextLine();

      Clube cUpd = new Clube(id, novoNome, novoCNPJ, novaCidade, 0, 0);
      

      if (crud.U(cUpd)) {
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

  // Cabecalho da opção 4
  public static void op4() {
    Menu.limpatela();
    System.out.println("+-------------------------------------------+");
    System.out.println("|        Remover um Clube                   |");
    System.out.println("+-------------------------------------------+");
    CRUD crud = new CRUD();
    Scanner sc = new Scanner(System.in);

    System.out.println("Digite o ID do Clube que deseja remover");
    byte idDel = sc.nextByte();
    if (crud.D(idDel) == true) {
      System.out.println("Time deletado com sucesso!");
    } else {
      System.out.println("Time não foi encontrado!");
    }
  }

  // Cabecalho da opção 5
  public static void op5() {
    Menu.limpatela();
    System.out.println("+-------------------------------------------+");
    System.out.println("|        Criar uma Partida                  |");
    System.out.println("+-------------------------------------------+");
  }

}
