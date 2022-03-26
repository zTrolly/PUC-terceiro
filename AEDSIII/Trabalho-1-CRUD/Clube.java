/**
 * declaracao default de classe e seus metodos para o trabalho 1
 * @author Breno Lopes
 * Matrícula: 725777
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.DataOutputStream;

//------------------------------FIM IMPORT---------------------------------//t
class Clube{
  protected int idClube;
  protected String nome;
  protected String cnpj;
  protected String cidade;
  protected int partidasJogadas;
  protected int pontos;

  public Clube(int _idClube, String _nome, String _cnpj, String _cidade, int _partidasJogadas, int _pontos){
    this.idClube = _idClube;
    this.nome = _nome;
    this.cnpj = _cnpj;
    this.cidade = _cidade;
    this.partidasJogadas = _partidasJogadas;
    this.pontos = _pontos;
  }

  public Clube(){
    this.idClube = -1;
    this.nome = "";
    this.cnpj = "";
    this.cidade = "";
    this.partidasJogadas = 0;
    this.pontos = 0;
  }

//GETS
  public int getIdClube(){ return this.idClube;}
  public String getNome(){ return this.nome;}
  public String getCnpj(){ return this.cnpj;}
  public String getCidade(){ return this.cidade;}
  public int getPartidasJogadas(){return this.partidasJogadas;}
  public int getPontos(){return this.pontos;}

  //SETS
  public void setIdClube(int _idClube){this.idClube = _idClube;}
  public void setNome(String _nome){this.nome = _nome;}
  public void setCnpj(String _cnpj){this.cnpj = _cnpj;}
  public void setCidade(String _cidade){this.cidade = _cidade;}
  public void setPartidasJogadas(int _partidasJogadas){this.partidasJogadas = _partidasJogadas;}
  public void setPontos(int _pontos){this.pontos = _pontos;}


  public byte[] TBA() throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    DataOutputStream dos = new DataOutputStream(baos);
    dos.write(idClube);
    dos.writeUTF(nome);
    dos.writeUTF(cnpj);
    dos.writeUTF(cidade);
    dos.write(partidasJogadas);
    dos.write(pontos);
    return baos.toByteArray();
}

public void FBA(byte[] ba) throws IOException {
    ByteArrayInputStream bais = new ByteArrayInputStream(ba);
    DataInputStream dis = new DataInputStream(bais);
    idClube = dis.readByte();
    nome = dis.readUTF();
    cnpj = dis.readUTF();
    cidade = dis.readUTF();
    partidasJogadas = dis.readByte();
    pontos = dis.readByte();
}

public String paraString() {
  return 
    "\nID: " + idClube +
    "\nNome clube: " + nome +
    "\nCNPJ: " + cnpj +
    "\nCidade: " + cidade + 
    "\nPartidas jogadas: " + partidasJogadas + 
    "\nPontos acumulados: " + pontos;
}

}

