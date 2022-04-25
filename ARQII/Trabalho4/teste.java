import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class teste {
  public static char x;
  public static char y;
  public static char op;
  public static BufferedReader buffRead;
  public static BufferedWriter buffWrite;
  public static Scanner input;

  //faz a decodificação do mnemonico
  public static void decodeULA(String line)throws IOException{
    if(line.equals("An;"))
      op = '0';
    else if(line.equals("nAoB;")){
      op = '1';
    }else if(line.equals("AnB;")){
      op = '2';
    }else if(line.equals("zeroL;")){
      op = '3';
    }else if(line.equals("nAeB;")){
      op = '4';
    }else if(line.equals("Bn;")){
      op = '5';
    }else if(line.equals("AxB;")){
      op = '6';
    }else if(line.equals("ABn;")){
      op = '7';
    }else if(line.equals("AnoB;")){
      op = '8';
    }else if(line.equals("nAxB;")){
      op = '9';
    }else if(line.equals("copiaB;")){
      op = 'A';
    }else if(line.equals("AB;")){
      op = 'B';
    }else if(line.equals("umL;")){
      op = 'C';
    }else if(line.equals("AoBn;")){
      op = 'D';
    }else if(line.equals("AoB;")){
      op = 'E';
    }else if(line.equals("copiaA;")){
      op = 'F';
    }
    escrever();
  }

  //faz a atribuição do valor para a variável
  public static void atribui(String linha){
    if(linha.charAt(0) == 'X')
      x = linha.charAt(2);
    else if(linha.charAt(0) == 'Y')
      y = linha.charAt(2);
  }
  
  //metodo de leitura de arquivo
  public static void ler(String path) throws IOException {
		buffRead = new BufferedReader(new FileReader(path));
		String linha;//linha única lida do arquivo
		do{
     	linha = buffRead.readLine();
		  if (linha != null && !linha.equals("fim.") && !linha.equals("inicio:")) {//verificação para ver se existem linhas
		    if(linha.charAt(1) == '=')
          atribui(linha);
        else
          decodeULA(linha);
        }
		}while(!linha.equals("fim.") && linha != null);
		buffRead.close();
	}

  //metodo de escrita dos mnemonicos
  public static void escrever() throws IOException {
		buffWrite.append(x + "" + y + "" + op);//escrevemos no arquivo
    buffWrite.newLine();	
	}

  public static void main(String[] args) {
    input = new Scanner(System.in);
    System.out.println("ARDUINO ULA 4 BITS");
    System.out.print("Caminho do arquivo de leitura: ");
    String path = input.nextLine();
    try{
      buffWrite = new BufferedWriter(new FileWriter("testeula.hex"));
      ler(path);
      buffWrite.close();//fechamos o arquivo
    }catch(Exception ex){
      ex.printStackTrace();
    }
  }
}