package br.com.uem.poo.clinica.relatorio.medico;

import br.com.uem.poo.clinica.entidade.Consulta;
import br.com.uem.poo.clinica.relatorio.Relatorio;
import br.com.uem.poo.clinica.util.DateTimeUtil;

import java.util.List;

public class ConsultasRealizadas implements Relatorio {
  private List<Consulta> consultas;

  public ConsultasRealizadas(List<Consulta> consultas) {
    this.consultas = consultas;
  }

  public List<Consulta> getConsultas() {
    return consultas;
  }

  public void setConsultas(List<Consulta> consultas) {
    this.consultas = consultas;
  }

  @Override
  public String geraRelatorio() {
    StringBuilder sb = new StringBuilder();
    sb.append("****  Saúde & Cia  ****\n");
    sb.append("     Lista de consultas\n");
    sb.append("Lista: \n");

    for (Consulta c : consultas) {
      sb.append(mostraConsulta(c)+"\n");
    }

    return sb.toString();
  }

  private String mostraConsulta(Consulta c){

    String dataConvertida = DateTimeUtil.converteLocalDateTimeParaString(c.getDiaHorario(), "HH:mm dd/MM/yyyy");

    return "Codigo: "+c.getId()
            +" Paciente: "+c.getPaciente().getNome()
            +" ID paciente: "+c.getPaciente().getId()
            +" Medico: "+c.getNomeMedico()
            +" Data: "+ dataConvertida;
  }

}
