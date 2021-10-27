package br.com.uem.poo.clinica.mensagem.email;

import br.com.uem.poo.clinica.mensagem.Mensageiro;

public class EmailMensagem implements Mensageiro{
  private String emailDestinatario;
  private String emailRemetente;
  private String assunto;
  private String corpoDoTexto;

  public EmailMensagem() {
  }

  public EmailMensagem(String emailDestinatario, String emailRemetente, String assunto, String corpoDoTexto) {
    this.emailDestinatario = emailDestinatario;
    this.emailRemetente = emailRemetente;
    this.assunto = assunto;
    this.corpoDoTexto = corpoDoTexto;
  }

  public String getEmailDestinatario() {
    return emailDestinatario;
  }

  public void setEmailDestinatario(String emailDestinatario) {
    this.emailDestinatario = emailDestinatario;
  }

  public String getEmailRemetente() {
    return emailRemetente;
  }

  public void setEmailRemetente(String emailRemetente) {
    this.emailRemetente = emailRemetente;
  }

  public String getAssunto() {
    return assunto;
  }

  public void setAssunto(String assunto) {
    this.assunto = assunto;
  }

  public String getCorpoDoTexto() {
    return corpoDoTexto;
  }

  public void setCorpoDoTexto(String corpoDoTexto) {
    this.corpoDoTexto = corpoDoTexto;
  }

  @Override
  public void enviaMensagem() {
    System.out.println("Enviando e-mail para : "+emailDestinatario);
    System.out.println("Assunto e-mail: "+assunto);
    System.out.println("Mensagem: "+corpoDoTexto);
    System.out.println("Essa opcao ainda nao funciona  \uD83E\uDD20");
  }
}
