package br.com.uem.poo.clinica.relatorio.medico;

import br.com.uem.poo.clinica.entidade.Paciente;
import br.com.uem.poo.clinica.relatorio.Relatorio;
import br.com.uem.poo.clinica.util.DateTimeUtil;

import java.time.LocalDate;

public class ReceitaMedica implements Relatorio {
  private Paciente paciente;
  private String medicamento;
  private String detalheDaMedicacao;
  private String nomeMedico;
  private LocalDate data;

  public ReceitaMedica(Paciente paciente, String medicamento, String detalheDaMedicacao, String nomeMedico, LocalDate data) {
    this.paciente = paciente;
    this.medicamento = medicamento;
    this.detalheDaMedicacao = detalheDaMedicacao;
    this.nomeMedico = nomeMedico;
    this.data = data;
  }

  public Paciente getPaciente() {
    return paciente;
  }

  public void setPaciente(Paciente paciente) {
    this.paciente = paciente;
  }

  public String getMedicamento() {
    return medicamento;
  }

  public void setMedicamento(String medicamento) {
    this.medicamento = medicamento;
  }

  public String getDetalheDaMedicacao() {
    return detalheDaMedicacao;
  }

  public void setDetalheDaMedicacao(String detalheDaMedicacao) {
    this.detalheDaMedicacao = detalheDaMedicacao;
  }

  public LocalDate getData() {
    return data;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  public String getNomeMedico() {
    return nomeMedico;
  }

  public void setNomeMedico(String nomeMedico) {
    this.nomeMedico = nomeMedico;
  }

  @Override
  public String geraRelatorio() {
    StringBuilder sb = new StringBuilder();
    String dataString = DateTimeUtil.converteLocalDateParaString(data, "dd/MM/yyyy");
    sb.append("****  Saúde & Cia  ****\n");
    sb.append("     RECEITA MEDICA\n");
    sb.append("Nome Paciente: "+paciente.getNome()+"\n");
    sb.append("Data: "+ dataString +"\n");
    sb.append("Medicamento: "+ medicamento +"\n");
    sb.append("Detalhes da medicacao: "+ detalheDaMedicacao +"\n");
    sb.append("Medico: "+ nomeMedico +"\n");

    return sb.toString();
  }
}
