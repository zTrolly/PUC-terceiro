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


  public byte[] toByteArray() throws IOException {
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

public void fromByteArray(byte[] ba) throws IOException {
    ByteArrayInputStream bais = new ByteArrayInputStream(ba);
    DataInputStream dis = new DataInputStream(bais);
    idClube = dis.readByte();
    nome = dis.readUTF();
    cnpj = dis.readUTF();
    cidade = dis.readUTF();
    partidasJogadas = dis.readByte();
    pontos = dis.readByte();
}

public String stringfy() {
  return "\nID: " + idClube + "\nNome clube: " + nome + "\nCNPJ: " + cnpj + "\nCidade: " + cidade + "\nPartidas jogadas: " + partidasJogadas + "\nPontos acumulados: " + pontos;
}
  
  /** 
   * metodo que verifica o nome dos dois times e atualiza os dados referentes ao número de partidasJogadas e pontos
   * @param golsClube1 @param golsClube2 , variaveis para determinar o número de gols de cada time
  */
  
  public void partida(Clube clube1, Clube clube2, int golsClube1, int golsClube2){
    clube1.setPartidasJogadas(clube1.getPartidasJogadas()+1);
    clube2.setPartidasJogadas(clube2.getPartidasJogadas()+1);

    /*
      *verificação dos números de gols para determinar o ganhador ou se empatou
    */
    if(golsClube1 > golsClube2){
      clube1.setPontos(clube1.getPontos() + 3);
    }else if(golsClube2 > golsClube1){
      clube2.setPontos(clube2.getPontos() + 3);
    }else if(golsClube1 == golsClube2){
      clube1.setPontos(clube1.getPontos() + 1);
      clube2.setPontos(clube2.getPontos() + 1);
    }
  }

}
















/*
TODO
-----------------
■ Criar um clube -> essa escolha deve, a partir da leitura dos dados do clube pelo
terminal (nome, cnpj, estado), criar um novo clube no arquivo (partidasJogadas
e pontos devem ser iniciados com 0). ✅

■ Realizar uma partida -> essa escolha deve atualizar dados em dois clubes no
arquivo.
  TODO
  ● Para isso, é necessário permitir ao usuário cadastrar uma partida, ou seja, informar o nome de dois times
   quantos gols fizeram.✅
   Cabe ao método criado definir o ganhador ou se foi empate.✅
   Caso tenha vencedor,deve-se somar 3 pontos para esse.✅
   Caso seja empate, deve-se somar 1 ponto para cada clube.✅
  Então, o programa deve atualizar o campo pontos e o campo partidasJogadas (em +1) dos dois clubes.✅

*/