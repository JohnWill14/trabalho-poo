package br.com.uem.poo.clinica.entidade;

import java.time.LocalDate;
import java.util.Objects;

public class Prontuario {
  private static Long numeroDeProntuarios = 0L;

  private Long id;
  private Paciente paciente;
  private String nomeMedico;
  private String sintomas;
  private String diagnosticoDoenca;
  private String tratamento;
  private LocalDate data;

  private Prontuario(){
    super();
  }

  public Prontuario(Long id, Paciente paciente, String nomeMedico, String sintomas, String diagnosticoDoenca, String tratamento, LocalDate data) {
    this.id = id;
    this.paciente = paciente;
    this.nomeMedico = nomeMedico;
    this.sintomas = sintomas;
    this.diagnosticoDoenca = diagnosticoDoenca;
    this.tratamento = tratamento;
    this.data = data;
  }

  public static Long getNumeroDeProntuarios() {
    return numeroDeProntuarios;
  }

  public static void setNumeroDeProntuarios(Long numeroDeProntuarios) {
    Prontuario.numeroDeProntuarios = numeroDeProntuarios;
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

  public String getSintomas() {
    return sintomas;
  }

  public void setSintomas(String sintomas) {
    this.sintomas = sintomas;
  }

  public String getDiagnosticoDoenca() {
    return diagnosticoDoenca;
  }

  public void setDiagnosticoDoenca(String diagnosticoDoenca) {
    this.diagnosticoDoenca = diagnosticoDoenca;
  }

  public String getTratamento() {
    return tratamento;
  }

  public void setTratamento(String tratamento) {
    this.tratamento = tratamento;
  }

  public LocalDate getData() {
    return data;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  public static class ProntuarioBuilder{
    private Long id;
    private Paciente paciente;
    private String nomeMedico;
    private String sintomas;
    private String diagnosticoDoenca;
    private String tratamento;
    private LocalDate data;


    public ProntuarioBuilder id(Long id){
      this.id = id;
      return this;
    }

    public ProntuarioBuilder paciente(Paciente paciente){
      this.paciente = paciente;
      return this;
    }

    public ProntuarioBuilder nomeMedico(String nomeMedico){
      this.nomeMedico = nomeMedico;
      return this;
    }

    public ProntuarioBuilder sintomas(String sintomas){
      this.sintomas = sintomas;
      return this;
    }

    public ProntuarioBuilder diagnosticoDoenca(String diagnosticoDoenca){
      this.diagnosticoDoenca = diagnosticoDoenca;
      return this;
    }

    public ProntuarioBuilder tratamento(String tratamento){
      this.tratamento = tratamento;
      return this;
    }

    public ProntuarioBuilder data(LocalDate date){
      this.data = date;
      return this;
    }

    public Prontuario build(){
      return new  Prontuario(id, paciente, nomeMedico, sintomas, diagnosticoDoenca, tratamento, data) ;
      }

  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Prontuario that = (Prontuario) o;
    return id.equals(that.id) && paciente.equals(that.paciente);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, paciente);
  }
}
