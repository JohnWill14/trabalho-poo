package br.com.uem.poo.clinica.entidade;

import java.time.LocalDateTime;

public class Consulta {
  private static  Long count = 0L;

  private Long id;
  private Paciente paciente;
  private String nomeMedico;
  private LocalDateTime diaHorario;
  private int duracao;

  {
    count +=1L;
    this.id = count;
  }

  public Consulta() {
    super();
  }

  public Consulta(Paciente paciente, String nomeMedico, LocalDateTime diaHorario, int duracao) {
    super();
    this.paciente = paciente;
    this.nomeMedico = nomeMedico;
    this.diaHorario = diaHorario;
    this.duracao = duracao;
  }

  public static Long getCount() {
    return count;
  }

  public static void setCount(Long count) {
    Consulta.count = count;
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

    private Paciente paciente;
    private String nomeMedico;
    private LocalDateTime diaHorario;
    private int duracao;

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
      return new Consulta(paciente, nomeMedico, diaHorario, duracao);
    }

  }

}
