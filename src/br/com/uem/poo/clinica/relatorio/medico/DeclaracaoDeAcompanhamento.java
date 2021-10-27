package br.com.uem.poo.clinica.relatorio.medico;

import br.com.uem.poo.clinica.entidade.Paciente;
import br.com.uem.poo.clinica.relatorio.Relatorio;
import br.com.uem.poo.clinica.util.DateTimeUtil;

import java.time.LocalDate;

public class DeclaracaoDeAcompanhamento implements Relatorio {
  private Paciente paciente;
  private String acompanhante;
  private LocalDate data;

  public DeclaracaoDeAcompanhamento(Paciente paciente, String acompanhante, LocalDate data) {
    this.paciente = paciente;
    this.acompanhante = acompanhante;
    this.data = data;
  }

  public Paciente getPaciente() {
    return paciente;
  }

  public void setPaciente(Paciente paciente) {
    this.paciente = paciente;
  }

  public String getAcompanhante() {
    return acompanhante;
  }

  public void setAcompanhante(String acompanhante) {
    this.acompanhante = acompanhante;
  }

  public LocalDate getData() {
    return data;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  @Override
  public String geraRelatorio() {
    StringBuilder sb = new StringBuilder();
    String dataString = DateTimeUtil.converteLocalDateParaString(data, "dd/MM/yyyy");
    sb.append("****  Saúde & Cia  ****\n");
    sb.append("     Declaracao de acompanhamento\n");
    sb.append("Nome Paciente: "+paciente.getNome()+"\n");
    sb.append("Acompanhante: "+acompanhante+"\n");
    sb.append("Data: "+ dataString +"\n");

    return sb.toString();
  }
}
