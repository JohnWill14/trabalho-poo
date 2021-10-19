package br.com.uem.poo.clinica.entidade;

import java.time.LocalDate;

public abstract class Pessoa {
  protected String nome;
  protected Contato contato;
  protected LocalDate dataNascimento;
  protected Character sexo;
  protected String estadoCivil;

  public Pessoa() {
    super();
  }

  public Pessoa(String nome, Contato contato, LocalDate dataNascimento, Character sexo, String estadoCivil) {
    super();
    this.nome = nome;
    this.contato = contato;
    this.dataNascimento = dataNascimento;
    this.sexo = sexo;
    this.estadoCivil = estadoCivil;
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


}
