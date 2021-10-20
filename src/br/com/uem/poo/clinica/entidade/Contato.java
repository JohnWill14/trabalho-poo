package br.com.uem.poo.clinica.entidade;

public class Contato {
  private String endereco;
  private String bairro;
  private String cidade;
  private String email;
  private String telefone;

  public Contato() {
    super();
  }

  public Contato(String endereco, String bairro, String cidade, String email, String telefone) {
    super();
    this.endereco = endereco;
    this.bairro = bairro;
    this.cidade = cidade;
    this.email = email;
    this.telefone = telefone;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public static class ContatoBuilder{
    private String endereco;
    private String bairro;
    private String cidade;
    private String email;
    private String telefone;

    public ContatoBuilder(){
      super();
    }

    public ContatoBuilder endereco(String endereco){
      this.endereco = endereco;
      return this;
    }

    public ContatoBuilder bairro(String bairro){
      this.bairro = bairro;
      return this;
    }

    public ContatoBuilder cidade(String cidade){
      this.cidade = cidade;
      return this;
    }

    public ContatoBuilder email(String email){
      this.email = email;
      return this;
    }

    public ContatoBuilder telefone(String telefone){
      this.telefone = telefone;
      return this;
    }

    public Contato build(){
      return new Contato( endereco,  bairro, cidade, email, telefone );
    }

  }

}
