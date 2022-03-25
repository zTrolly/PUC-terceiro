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

/**
 * Método para criaçõo de um Clube
 */
  public void C (Clube clubeUsuario, int id){
    byte[] data;
    try {
      arq = new RandomAccessFile(nomeDoArquivo, "rw");
      data = clubeUsuario.toByteArray();
      arq.seek(0);
      arq.writeInt(id);
      arq.seek(arq.length());
      arq.writeChar(' ');
      arq.writeInt(data.length);
      arq.write(data);
      arq.close();
    }catch(IOException e){System.out.println(e.getMessage() + "erro de inserção");}
  }

  public void R() {
    try {
        arq = new RandomAccessFile(nomeDoArquivo, "rw");
        arq.seek(0);

        char lapide;
        byte[] data;
        int tam;
        Clube clube;

        while (arq.getFilePointer() < arq.length()) {
            lapide = arq.readChar();
            tam = arq.readInt();
            data = new byte[tam];
            arq.read(data);
            if (lapide != '*') {
                clube = new Clube();
                clube.fromByteArray(data);
                System.out.println(clube.stringfy());
            }
        }
    } catch (Exception e) {System.out.println(e.getMessage());}
}
}
