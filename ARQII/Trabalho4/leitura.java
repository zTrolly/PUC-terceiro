import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class leitura {
    File arquivoLeitura = new File("testeula.ula");
    
    public static char OperacaoW(String w) {
        char tmp = ' ';
        switch (w) {
            case "An;":
                tmp = '0';
                break;
            case "nAoB;":
                tmp = '1';
                break;
            case "AnB;":
                tmp = '2';
                break;
            case "zeroL;":
                tmp = '3';
                break;
            case "nAeB;":
                tmp = '4';
                break;
            case "Bn;":
                tmp = '5';
                break;
            case "AxB;":
                tmp = '6';
                break;
            case "ABn;":
                tmp = '7';
                break;
            case "AnoB;":
                tmp = '8';
                break;
            case "nAxB;":
                tmp = '9';
                break;
            case "copiaB;":
                tmp = 'A';
                break;
            case "AB;":
                tmp = 'B';
                break;
            case "umL;":
                tmp = 'C';
                break;
            case "AoBn;":
                tmp = 'D';
                break;
            case "AoB;":
                tmp = 'E';
                break;
            case "copiaA;":
                tmp = 'F';
                break;
            default:
                System.out.println("Erro");
                break;
        }

        return tmp;
    }

    static void lerArquivo() throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("testeula.ula"));
        String linha = "";
        char x = ' ', y = ' ';
        String tmp = ""; 
        while(linha != null && !linha.equals("fim.") && !linha.equals("inicio:")){
            linha = br.readLine();
            
            if(linha.charAt(0) == 'X' ){
                x = linha.charAt(2);       
            } else if(linha.charAt(0) == 'Y'){
                y = linha.charAt(2);
            } else if(linha.charAt(0) == 'W'){
                tmp = linha;
                tmp.substring(2, tmp.length()-1);
                char w = OperacaoW(tmp);
                printarOperacao(x,y,w);
            }
            
        }

        br.close();

    }

    private static void printarOperacao(char x, char y, char w) throws Exception {
        FileWriter d = new FileWriter("testeula2.hex");
        BufferedWriter bw = new BufferedWriter(d);
        String linha = "";
        String x1 = String.valueOf(x);
        linha.concat(x1);
        String y1 = String.valueOf(y);
        linha.concat(y1);
        String w1 = String.valueOf(w);
        linha.concat(w1);
        bw.write(linha);
        System.out.println(linha);
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        
        lerArquivo();

    }
}