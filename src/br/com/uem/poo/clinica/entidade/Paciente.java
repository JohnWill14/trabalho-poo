package br.com.uem.poo.clinica.entidade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Paciente extends Pessoa{
  private static  Long count = 0L;

  private Long id;
  private final List<String> dadosAdicionais = new ArrayList<>();
  private String tipoConvenio;


  {
    count +=1L;
    this.id = count;
  }
  public Paciente() {
    super();
  }

  public Paciente(String nome, Contato contato, LocalDate dataNascimento, Character sexo, String estadoCivil, String tipoConvenio) {
    super(nome, contato, dataNascimento, sexo, estadoCivil);
    this.tipoConvenio = tipoConvenio;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<String> getDadosAdicionais() {
    return dadosAdicionais;
  }

  public static class PacienteBuilder{
    private String nome;
    private Contato contato;
    private LocalDate dataNascimento;
    private Character sexo;
    private String estadoCivil;
    private Long id;
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
      return new Paciente(nome, contato, dataNascimento, sexo, estadoCivil, tipoConvenio);
    }

  }

}