public class Menu{
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
    Menu.limpatela();
    System.out.println("+-------------------------------------------+");
		System.out.println("|        Criar um Clube                     |");
		System.out.println("+-------------------------------------------+");
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

