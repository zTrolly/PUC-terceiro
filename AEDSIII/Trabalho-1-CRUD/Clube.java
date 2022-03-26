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

//------------------------------FIM IMPORT---------------------------------//
class Clube{
  protected int idClube;
  protected String nome;
  protected String cnpj;
  protected String cidade;
  protected int partidas;
  protected int pontos;

  public Clube(int _idClube, String _nome, String _cnpj, String _cidade, int _partidas, int _pontos){
    this.idClube = _idClube;
    this.nome = _nome;
    this.cnpj = _cnpj;
    this.cidade = _cidade;
    this.partidas = _partidas;
    this.pontos = _pontos;
  }

  public Clube(){
    this.idClube = -1;
    this.nome = "";
    this.cnpj = "";
    this.cidade = "";
    this.partidas = 0;
    this.pontos = 0;
  }

//GETS
  public int getIdClube(){ return this.idClube;}
  public String getNome(){ return this.nome;}
  public String getCnpj(){ return this.cnpj;}
  public String getCidade(){ return this.cidade;}
  public int getPartidas(){return this.partidas;}
  public int getPontos(){return this.pontos;}

  //SETS
  public void setIdClube(int _idClube){this.idClube = _idClube;}
  public void setNome(String _nome){this.nome = _nome;}
  public void setCnpj(String _cnpj){this.cnpj = _cnpj;}
  public void setCidade(String _cidade){this.cidade = _cidade;}
  public void setPartidas(int _partidas){this.partidas = _partidas;}
  public void setPontos(int _pontos){this.pontos = _pontos;}


//------------------------------FIM CONSTRUTOR---------------------------------//

/**
 * metodo para aumentar o numero de partidas de um clube 
 * */
  public void partidas() {
    this.partidas++;
}
/**
 * metodo para aumentar o numero de pontos de um clube 
 * */
public void pontos(int x) {
    this.pontos += x;
}
/**
 * Método para transformar um objeto em um byte array para ser armazenado no arquivo .db
 * @return
 * @throws IOException
 */
  public byte[] TBA() throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    DataOutputStream dos = new DataOutputStream(baos);
    dos.write(idClube);
    dos.writeUTF(nome);
    dos.writeUTF(cnpj);
    dos.writeUTF(cidade);
    dos.write(partidas);
    dos.write(pontos);
    return baos.toByteArray();
}
/**
 * método para pegar um byte array e transformar ele um um objeto
 * @param ba parametro que recebe byte array
 * @throws IOException
 */
public void FBA(byte[] ba) throws IOException {
    ByteArrayInputStream bais = new ByteArrayInputStream(ba);
    DataInputStream dis = new DataInputStream(bais);
    idClube = dis.readByte();
    nome = dis.readUTF();
    cnpj = dis.readUTF();
    cidade = dis.readUTF();
    partidas = dis.readByte();
    pontos = dis.readByte();
}

/**
 * Retorna o objeto em forma de string pra ser utilizado em outros metodos
 * @return
 */
public String paraString() {
  return 
    "\nID: " + idClube +
    "\nClube: " + nome +
    "\nCNPJ: " + cnpj +
    "\nCidade: " + cidade + 
    "\nPartidas: " + partidas + 
    "\nPontos: " + pontos;
}

}

