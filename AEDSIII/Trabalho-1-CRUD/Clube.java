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

  public int getIdClube(){ return this.idClube;}
  public int getIdClube(){ return this.idClube;}

}