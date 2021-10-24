package br.com.uem.poo.clinica.relatorio.medico;

import br.com.uem.poo.clinica.entidade.Paciente;
import br.com.uem.poo.clinica.relatorio.Relatorio;

public class ReceitaMedica implements Relatorio {
  private Paciente paciente;
  private String medicamento;


  @Override
  public String geraRelatorio() {
    return null;
  }
}
