import java.util.Scanner;

public class Main {
  

  public static void main(String[] args) throws Exception{
    byte opcao = 50;
		Scanner leitor = new Scanner(System.in);
    do {
      Menu.showMenu();
			System.out.print("Opção escolhida: ");
			opcao = leitor.nextByte();
       switch (opcao){
          case 1:
           Menu.op1();
          break;

          case 2:
           Menu.op2();
          break;

          case 3:
           Menu.op3();
          break;

          case 4:
           Menu.op4();
          break;

          case 5:
           Menu.op5();
          break;
       }

    } while (opcao != 99);
    leitor.close();
  }
}
