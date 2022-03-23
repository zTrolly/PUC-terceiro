import java.io.IOException;
  
public class Main {
  public static void cls()
{
	try
	{	
		new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
	}catch(Exception E)
		{
			System.out.println(E);
		}
}
  public static void main(String[] args){
    Menu.showMenu();
  }
}
