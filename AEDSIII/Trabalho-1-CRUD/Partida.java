class Partida  extends Clube{
  private String nomeClube1;
  private String nomeClube2;
  private byte golsClube1;
  private byte golsClube2;

  public Partida(String _nomeClube1, String _nomeClube2, byte _golsClube1, byte _golsClube2){
    this.nomeClube1 = _nomeClube1;
    this.nomeClube1 = _nomeClube2;
    this.golsClube1 = _golsClube1;
    this.golsClube2 = _golsClube2;
  }

  public Partida(){
    this.nomeClube1 = "";
    this.nomeClube2 = "";
    this.golsClube1 = 0;
    this.golsClube2 = 0;
  }
  //GETS
  public String getNomeClube1(){return this.nomeClube1;}
  public String getNomeClube2(){return this.nomeClube2;}
  public byte getGolsClube1(){return this.golsClube1;}
  public byte getGolsClube2(){return this.golsClube2;}

  //SETS 
  public void setNomeClube1(String _nomeClube1){this.nomeClube1=_nomeClube1;}
  public void setNomeClube2(String _nomeClube2){this.nomeClube2=_nomeClube2;}
  public void setGolsClube1(byte _golsClube1){this.golsClube1= _golsClube1;}
  public void setGolsClube2(byte _golsClube2){this.golsClube1= _golsClube2;}


  public void criar(String nomeClube1, String nomeClube2, byte golsClube1, byte golsClube2){
    

  }
}
