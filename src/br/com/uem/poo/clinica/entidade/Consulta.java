package br.com.uem.poo.clinica.entidade;

import java.time.LocalDateTime;
import java.util.Objects;

public class Consulta {
  private static  Long numeroConsulta = 0L;

  private Long id;
  private Paciente paciente;
  private String nomeMedico;
  private LocalDateTime diaHorario;
  private int duracao;

  {

  }

  public Consulta() {
    super();
  }

  public Consulta(Long id, Paciente paciente, String nomeMedico, LocalDateTime diaHorario, int duracao) {
    super();
    this.id = id;
    this.paciente = paciente;
    this.nomeMedico = nomeMedico;
    this.diaHorario = diaHorario;
    this.duracao = duracao;
  }

  public static Long getNumeroConsulta() {
    return numeroConsulta;
  }

  public static void setNumeroConsulta(Long numeroConsulta) {
    Consulta.numeroConsulta = numeroConsulta;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Paciente getPaciente() {
    return paciente;
  }

  public void setPaciente(Paciente paciente) {
    this.paciente = paciente;
  }

  public String getNomeMedico() {
    return nomeMedico;
  }

  public void setNomeMedico(String nomeMedico) {
    this.nomeMedico = nomeMedico;
  }

  public LocalDateTime getDiaHorario() {
    return diaHorario;
  }

  public void setDiaHorario(LocalDateTime diaHorario) {
    this.diaHorario = diaHorario;
  }

  public int getDuracao() {
    return duracao;
  }

  public void setDuracao(int duracao) {
    this.duracao = duracao;
  }

  public static class ConsultaBuild{

    private Long id;
    private Paciente paciente;
    private String nomeMedico;
    private LocalDateTime diaHorario;
    private int duracao;

    public ConsultaBuild id(Long id){
      this.id = id;
      return this;
    }

    public ConsultaBuild paciente(Paciente paciente){
      this.paciente = paciente;
      return this;
    }

    public ConsultaBuild nomeMedico(String nomeMedico){
      this.nomeMedico = nomeMedico;
      return this;
    }

    public ConsultaBuild diaHorario(LocalDateTime diaHorario){
      this.diaHorario = diaHorario;
      return this;
    }

    public ConsultaBuild duracao(Integer duracao){
      this.duracao = duracao;
      return this;
    }

    public  Consulta build(){
      return new Consulta(id, paciente, nomeMedico, diaHorario, duracao);
    }

  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Consulta consulta = (Consulta) o;
    return id.equals(consulta.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
