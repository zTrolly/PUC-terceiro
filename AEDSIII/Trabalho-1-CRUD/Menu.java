import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Menu extends Clube{

  /**
     * Faz a leitura do último ID utilizado pra ser incrementeado no main
     */
    public static int ultimoId(int id) {
      RandomAccessFile arquivo;
      int ultimoId;
      try {
          arquivo = new RandomAccessFile("clubes.db", "rw");
          ultimoId = arquivo.readInt();
          arquivo.close();
          return ultimoId;
      } catch(IOException e) {
          System.out.println("Erro em ler id");
          return id;
      }
    }
  //Metodo para limpar o terminal
  public static void limpatela() { 
    System.out.println("\u000c");
    System.out.println("\u000c");
    System.out.println("\u000c");
    System.out.println("\u000c");
  }
  /*Metodo para imprimir o menu principal*/
  public static void showMenu (){
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
  //Cabecalho da opção 1 
  public static void op1(){
    CRUD crud = new CRUD();
    Scanner sc = new Scanner(System.in);
    String nome;
    String cnpj;
    String cidade;

    Menu.limpatela();
    System.out.println("+-------------------------------------------+");
		System.out.println("|        Criar um Clube                     |");
		System.out.println("+-------------------------------------------+");
   
    int id = -1;
    id = ultimoId(id);
    id++;
    System.out.println("Aperte qualquer tecla para iniciar...");
    sc.nextLine();
    System.out.print("Digite o nome do Clube ->");
    nome = sc.nextLine();
    System.out.print("Digite o CNPJ do clube ->");
    cnpj = sc.nextLine();
    System.out.print("Digite a cidade do clube ->");
    cidade = sc.nextLine();
    Clube novoClube = new Clube((byte) id, nome, cnpj, cidade, 0, 0);
    crud.C(novoClube, id);
    }

  //Cabecalho da opção 2
  public static void op2(){
    Menu.limpatela();
    System.out.println("+-------------------------------------------+");
		System.out.println("|        Lista de Clubes                    |");
		System.out.println("+-------------------------------------------+");

  }

  //Cabecalho da opção 3
  public static void op3(){
    Menu.limpatela();
    System.out.println("+-------------------------------------------+");
		System.out.println("|        Editar um Clube                    |");
		System.out.println("+-------------------------------------------+");
  }

  //Cabecalho da opção 4
  public static void op4(){
    Menu.limpatela();
    System.out.println("+-------------------------------------------+");
		System.out.println("|        Remover um Clube                   |");
		System.out.println("+-------------------------------------------+");
  }


  //Cabecalho da opção 5
  public static void op5(){
    Menu.limpatela();
    System.out.println("+-------------------------------------------+");
		System.out.println("|        Criar uma Partida                  |");
		System.out.println("+-------------------------------------------+");
  }

}

