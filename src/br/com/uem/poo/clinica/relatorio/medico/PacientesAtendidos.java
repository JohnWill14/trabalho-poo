package br.com.uem.poo.clinica.relatorio.medico;

import br.com.uem.poo.clinica.entidade.Consulta;
import br.com.uem.poo.clinica.entidade.Paciente;
import br.com.uem.poo.clinica.relatorio.Relatorio;
import br.com.uem.poo.clinica.util.DateTimeUtil;

import java.util.List;

public class PacientesAtendidos implements Relatorio {
  private String medico;
  private List<Paciente> pacientes;

  public PacientesAtendidos(String medico, List<Paciente> pacientes) {
    this.medico = medico;
    this.pacientes = pacientes;
  }

  public String getMedico() {
    return medico;
  }

  public void setMedico(String medico) {
    this.medico = medico;
  }

  public List<Paciente> getPacientes() {
    return pacientes;
  }

  public void setPacientes(List<Paciente> pacientes) {
    this.pacientes = pacientes;
  }

  @Override
  public String geraRelatorio() {
    StringBuilder sb = new StringBuilder();
    sb.append("****  Saúde & Cia  ****\n");
    sb.append("     Lista de pacientes atendidos por medico\n");
    sb.append("Nome Medico: "+medico+"\n");
    sb.append("Lista pacientes: \n");

    for (Paciente p : pacientes) {
      sb.append(mostraPaciente(p)+"\n");
    }

    return sb.toString();
  }

  private String mostraPaciente(Paciente p){

    String dataConvertida = DateTimeUtil.converteLocalDateParaString(p.getDataNascimento(), "dd/MM/yyyy");

    return "Codigo: "+p.getId()
            +" Paciente: "+p.getNome()
            +" Email: "+p.getContato().getEmail()
            +" Telefone: "+p.getContato().getTelefone()
            +" Data Nascimento: "+ dataConvertida;
  }

}
