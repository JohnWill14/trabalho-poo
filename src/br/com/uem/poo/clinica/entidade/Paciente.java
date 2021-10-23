package br.com.uem.poo.clinica.entidade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Paciente{
  private static  Long numeroPaciente = 0L;

  private Long id;
  private String nome;
  private Contato contato;
  private LocalDate dataNascimento;
  private Character sexo;
  private String estadoCivil;
  private List<String> dadosAdicionais = new ArrayList<>();
  private String tipoConvenio;

  public Paciente() {
    super();
  }

  public Paciente(Long id, String nome, Contato contato, LocalDate dataNascimento, Character sexo, String estadoCivil, String tipoConvenio) {
    this.id = id;
    this.nome = nome;
    this.contato = contato;
    this.dataNascimento = dataNascimento;
    this.sexo = sexo;
    this.estadoCivil = estadoCivil;
    this.tipoConvenio = tipoConvenio;
  }

  public static Long getNumeroPaciente() {
    return numeroPaciente;
  }

  public static void setNumeroPaciente(Long numeroPaciente) {
    Paciente.numeroPaciente = numeroPaciente;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Contato getContato() {
    return contato;
  }

  public void setContato(Contato contato) {
    this.contato = contato;
  }

  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public Character getSexo() {
    return sexo;
  }

  public void setSexo(Character sexo) {
    this.sexo = sexo;
  }

  public String getEstadoCivil() {
    return estadoCivil;
  }

  public void setEstadoCivil(String estadoCivil) {
    this.estadoCivil = estadoCivil;
  }

  public List<String> getDadosAdicionais() {
    return dadosAdicionais;
  }

  public String getTipoConvenio() {
    return tipoConvenio;
  }

  public void setTipoConvenio(String tipoConvenio) {
    this.tipoConvenio = tipoConvenio;
  }

  public void setDadosAdicionais(List<String> dadosAdicionais) {
    this.dadosAdicionais = dadosAdicionais;
  }

  public static class PacienteBuilder{
    private Long id;
    private String nome;
    private Contato contato;
    private LocalDate dataNascimento;
    private Character sexo;
    private String estadoCivil;
    private String tipoConvenio;

    public PacienteBuilder() {
      super();
    }

    public PacienteBuilder nome(String nome){
      this.nome = nome;
      return this;
    }

    public PacienteBuilder endereco(String nome){
      this.nome = nome;
      return this;
    }

    public PacienteBuilder contato(Contato contato){
      this.contato = contato;
      return this;
    }

    public PacienteBuilder dataNascimento(LocalDate dataNascimento){
      this.dataNascimento = dataNascimento;
      return this;
    }

    public PacienteBuilder sexo(Character sexo){
      this.sexo = sexo;
      return this;
    }

    public PacienteBuilder estadoCivil(String estadoCivil){
      this.estadoCivil = estadoCivil;
      return this;
    }

    public PacienteBuilder tipoConvenio(String tipoConvenio){
      this.tipoConvenio = tipoConvenio;
      return this;
    }

    public PacienteBuilder id(Long id){
      this.id = id;
      return this;
    }

    public Paciente build(){
      return new Paciente(id, nome, contato, dataNascimento, sexo, estadoCivil, tipoConvenio);
    }

  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Paciente paciente = (Paciente) o;
    return id.equals(paciente.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
