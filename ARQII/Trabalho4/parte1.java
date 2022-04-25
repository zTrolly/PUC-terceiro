import java.io.*;
import java.util.Scanner;


//Classe para gravar as instrucoes
class Text {
    private RandomAccessFile arq;
    private final String fileName = "testeula.hex";
    private char x;
    private char y;
    private char w;

    public char getX() {
        return x;
    }

    public void setX(char x) {
        this.x = x;
    }

    public char getY() {
        return y;
    }

    public void setY(char y) {
        this.y = y;
    }

    public char getW() {
        return w;
    }

    public void setW(char w) {
        this.w = w;
    }

    public Text(char a, char b, char c) {
        x = a;
        y = b;
        w = c;
    }

    public Text() {
        x = 'X';
        y = 'Y';
        w = 'W';
    }

    public String merge() {
        return "" + x + y + w;
    }


}

public class parte1 {


/**
 * 
 * @param s -> Linha do arquivo que vai ser lido
 * @param base -> Objeto text que recebe a string s
 * @return -> objeto tratado
 */
    public static Text input(String s, Text base) {
        if (testInput(s)) {
            switch (s.charAt(0)) {
                case 'X':
                    if (testValue(s)) {
                        base.setX(s.charAt(2));
                    }
                    break;
                case 'Y':
                    if (testValue(s)) {
                        base.setY(s.charAt(2));
                    }
                    break;
                case 'W':
                    base.setW(treatW(s.substring(2)));
                    //escrever no arquivo o base.merge();
                    //TODO
                    break;
                default:
                    break;
            }
        }
        return base;
        //retorna o objeto tratado, a resposta em outras palavras
    }


    /**
     * 
     * @param s -> string "crua"
     * @return
     */
    // Funcao para conferir um input
    public static boolean testInput(String s) {
        // confere se o tamanho minimo do input estah correto
        if (s.length() >= 4) {
            // confere o se o primeiro char do comando eh X, Y ou W
            if (s.charAt(0) >= 87 && s.charAt(0) <= 89) {
                // confere se o segundo char eh o simbolo '='
                if (s.charAt(1) == '=') {
                    return true;
                }
            }
        }
        return false;
    }



    // Funcao que confere se o valor do input eh adequado para hex(0 a F)
    public static boolean testValue(String s) {
        if (s.charAt(3) == ';') {
            if ((s.charAt(2) >= 65 && s.charAt(2) <= 70) || (s.charAt(2) >= 48 && s.charAt(2) <= 57)) {
                return true;
            }
        }
        return false;
    }

    // Funcao para tratar a opcao 'W'
    public static char treatW(String w) {
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



    public static void main(String[] args) {
        Text base = new Text();
        Scanner scan = new Scanner(System.in);


        String s = scan.nextLine();
        while(s != "inicio:"){
            s = scan.nextLine();
        }
        scan.nextLine();
        
        do {
            s = scan.nextLine();
            base = input(s, base);
            System.out.println(base.merge());
        } while (scan.next() != "fim.");
        
        




    }

}