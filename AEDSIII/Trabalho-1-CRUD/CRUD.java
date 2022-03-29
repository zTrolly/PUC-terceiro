/**
 * Classe CRUD para fazer as alterações no arquivo clubes.db
 * @author Breno Lopes
 * Matrícula: 725777
 */

import java.io.*;
public class CRUD {
   private final String nomeDoArquivo = "clubes.db";
   private RandomAccessFile arq;

/**
 * Mertodo oara iniciar o crud e força o primeiro ID  a ser 0
 */
  public CRUD(){
    try {
      boolean verificaArquivo = (new File(nomeDoArquivo)).exists();
      if (!verificaArquivo){
        try {
          int id = -1;
          arq = new RandomAccessFile(nomeDoArquivo, "rw");
          arq.writeInt(id);
          arq.close();
        } catch (Exception e){System.out.println(e.getMessage() + "erro em criar o id");}
      }
    }catch(Exception e){System.out.println(e.getMessage());}
  }

//CREATE
/**
 * Método para criaçõo de um Clube utilizando o id passado pelo Menu.op1()
 */
  public void C (Clube clubeUsuario, int id){
    byte[] data;
    try {
      arq = new RandomAccessFile(nomeDoArquivo, "rw");
      data = clubeUsuario.TBA();
      arq.seek(0);
      arq.writeInt(id);
      arq.seek(arq.length());
      arq.writeChar(' '); // lapide
      arq.writeInt(data.length);
      arq.write(data);
      arq.close();
    }catch(IOException e){System.out.println(e.getMessage() + "erro de inserção");}
  }


  /**
   * Vai fazer toda a leitura do arquvio e vai pular o cabecalho
   */
  public void R() {
    try {
        arq = new RandomAccessFile(nomeDoArquivo, "rw");
        arq.seek(4);

        byte[] data;
        Clube clube;
        char lapide;
        int TAM;

        while (arq.getFilePointer() < arq.length()) {
            lapide = arq.readChar();
            TAM = arq.readInt();
            data = new byte[TAM];
            arq.read(data);
            if (lapide != '*') {
                clube = new Clube();
                clube.FBA(data);
                System.out.println(clube.paraString());
            }
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
  }

  /**
   * Recebe um clube e que vai substiruir o Clube ja  presente no arquivo
   * Além disso é preciso aumentar o seek para não sobrescrever os dados
   * @param clubeUsuario
   * @return
   */
  public boolean U(Clube clubeUsuario){
    try {
      byte[] data;
      Clube clube;
      byte[] newData;
      long posicao;
      char lapide;
      int TAM;

      arq = new RandomAccessFile(nomeDoArquivo, "rw");
      arq.seek(4);

      while(arq.getFilePointer() < arq.length()) {
          posicao = arq.getFilePointer();
          lapide = arq.readChar();
          TAM = arq.readInt();
          data = new byte[TAM];

          arq.read(data);

          if (lapide != '*') {
              clube = new Clube();
              clube.FBA(data);
              if (clube.getIdClube() == clubeUsuario.getIdClube()) {
                  newData = clubeUsuario.TBA();
                  if (newData.length <= TAM) {
                      arq.seek(posicao + 6);
                      arq.write(newData);
                      arq.close();
                  } else {
                      arq.seek(arq.length());
                      arq.writeChar(' ');
                      arq.writeInt(newData.length);
                      arq.write(newData);
                      D(clube.getIdClube());
                      arq.close();
                  }
                  return true;
              }
          }
      }
      arq.close();
      return false;
  } catch (Exception e) {
      System.out.println(e.getMessage());
      return false;
    }
  }

  /**
   * remove o clube do arquivo
   * @param id do clube removido
   * @return
   */
  public boolean D(int id) {
    try {
        byte[] data;
        Clube clube;
        long posicao;
        char lapide;
        int TAM;

        arq = new RandomAccessFile(nomeDoArquivo, "rw");
        arq.seek(4);

        while(arq.getFilePointer() < arq.length()) {
            posicao = arq.getFilePointer();
            lapide = arq.readChar();
            TAM = arq.readInt();
            data = new byte[TAM];
            arq.read(data);
            if(lapide != '*') {
                clube = new Clube();
                clube.FBA(data);
                if(clube.getIdClube() == id) {
                    arq.seek(posicao);
                    arq.writeChar('*');
                    arq.close();
                    return true;
                }
            }
        }
        arq.close();
        return false;
    } catch(IOException e) {
        System.out.println(e.getMessage());
        return false;
    }
    
}
/*---------------------------- UTILITARIOS ------------------------------- */
/**
 * faz uma busca no arquivo comparando o id e retnora falso se o no e nao existir
 * @param id
 * @return
 */
  public boolean pesquisaId(int id) {
        try {
            arq = new RandomAccessFile(nomeDoArquivo, "rw");

            byte[] data;
            Clube objeto;
            char lapide;
            int TAM;

            arq.seek(4);

            while (arq.getFilePointer() < arq.length()) {
                lapide = arq.readChar();
                TAM = arq.readInt();
                data = new byte[TAM];
                arq.read(data);

                if (lapide != '*') {
                    objeto = new Clube();
                    objeto.FBA(data);

                    if (objeto.getIdClube() == id) {
                        System.out.println(objeto.paraString());
                        return true;
                    }
                }
            }
            return false;

        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    /**
     * Mesma coisa do que o pesquisaId mas utiliza o nome como parametro
     * @param nomeClube
     * @return retorna o clube desejado utilizado para fazer as partidas
     */
    public Clube pesquisaNome(String nomeClube) {
      try {
          arq = new RandomAccessFile(nomeDoArquivo, "rw");

          byte[] data;
          Clube clube;
          int TAM;

          arq.seek(4);

          while (arq.getFilePointer() < arq.length()) {
              char lapide = arq.readChar();
              TAM = arq.readInt();
              data = new byte[TAM];
              arq.read(data);

              if (lapide != '*') {
                  clube = new Clube();
                  clube.FBA(data);
                  if (clube.nome.equals(nomeClube)) {
                      return clube;
                  }
              }
          }

          return null;
      } catch (IOException e) {
          System.out.println(e.getMessage());
          return null;
      }
  }


  /**
   * partida dos dois clubes e efetua o update dos clubes
   * @param nomeClube1  nome dos clubes
   * @param nomeClube2
   * @param golsClube1 qtds de gols
   * @param golsClube2
   */
  public void criarPartida(String nomeClube1, String nomeClube2, int golsClube1, int golsClube2) {
    Clube clube1 = pesquisaNome(nomeClube1);
    Clube clube2 = pesquisaNome(nomeClube2);

    clube1.partidas();
    clube2.partidas();

    // verifica resultado
    if (golsClube1 > golsClube2) {
        clube1.pontos(3);
    } else if (golsClube1 < golsClube2) {
        clube2.pontos(3);
    } else {
        clube1.pontos(1);
        clube2.pontos(1);
    }
    if (U(clube1) && U(clube2)) {
        System.out.println("Partida executada, os pontos foram acrescentados nos dois times");
    } else {
        System.out.println("erro");
    }
}
}
