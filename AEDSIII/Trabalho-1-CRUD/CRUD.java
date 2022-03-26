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
 * Método para criaçõo de um Clube
 */
  public void C (Clube clubeUsuario, int id){
    byte[] data;
    try {
      arq = new RandomAccessFile(nomeDoArquivo, "rw");
      data = clubeUsuario.TBA();
      arq.seek(0);
      arq.writeInt(id);
      arq.seek(arq.length());
      arq.writeChar(' ');
      arq.writeInt(data.length);
      arq.write(data);
      arq.close();
    }catch(IOException e){System.out.println(e.getMessage() + "erro de inserção");}
  }


  //READ
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

  //UPDATE
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

  //DELETE
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
                        System.out.println(objeto);
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
}
