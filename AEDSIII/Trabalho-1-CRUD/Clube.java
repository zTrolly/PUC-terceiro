/**
 * declaracao default do trabalho1
 * @author Breno Lopes
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.DataOutputStream;
import java.text.DecimalFormat;

//------------------------------FIM IMPORT---------------------------------//t
class Clube{
  private int idClube;
  private String nome;
  private String cnpj;
  private String cidade;
  private int partidasJogadas;
  private int pontos;

  public Clube(int idClube, String nome, String cnpj, String cidade, int partidasJogadas, int pontos){
    this.idClube = idClube;
    this.nome = nome;
    this.cnpj = cnpj;
    this.cidade = cidade;
    this.partidasJogadas = partidasJogadas;
    this.pontos = pontos;
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
  public void setIdClube(int idClube){this.idClube = idClube;}
  public void setNome(String nome){this.nome = nome;}
  public void setCnpj(String cnpj){this.cnpj = cnpj;}
  public void setCidade(String cidade){this.cidade = cidade;}
  public void setPartidasJogadas(int partidasJogadas){this.partidasJogadas = partidasJogadas;}
  public void setPontos(int pontos){this.pontos = pontos;}

public void partidas(Clube clube1, Clube clube2){
  clube1.setPartidasJogadas(clube1.getPartidasJogadas()+1);
  clube2.setPartidasJogadas(clube2.getPartidasJogadas()+1);
}


}