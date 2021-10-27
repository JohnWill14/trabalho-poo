package br.com.uem.poo.clinica.mensagem.sms;

import br.com.uem.poo.clinica.mensagem.Mensageiro;

public class SmsMensagem implements Mensageiro {
  private String telefoneDestinatario;
  private String telefoneRemetente;
  private String mensagem;

  public SmsMensagem() {
  }

  public SmsMensagem(String telefoneDestinatario, String telefoneRemetente, String mensagem) {
    this.telefoneDestinatario = telefoneDestinatario;
    this.telefoneRemetente = telefoneRemetente;
    this.mensagem = mensagem;
  }

  public String getTelefoneDestinatario() {
    return telefoneDestinatario;
  }

  public void setTelefoneDestinatario(String telefoneDestinatario) {
    this.telefoneDestinatario = telefoneDestinatario;
  }

  public String getTelefoneRemetente() {
    return telefoneRemetente;
  }

  public void setTelefoneRemetente(String telefoneRemetente) {
    this.telefoneRemetente = telefoneRemetente;
  }

  public String getMensagem() {
    return mensagem;
  }

  public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
  }

  @Override
  public void enviaMensagem() {
    System.out.println("Enviando sms para : "+ telefoneDestinatario);
    System.out.println("Mensagem: "+ mensagem);
    System.out.println("Essa opcao ainda nao funciona  \uD83E\uDD20");
  }
}
