package br.com.uem.poo.clinica.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeUtil {

  public static LocalDate converteStringParaLocalDate(String data, String formato){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
    return LocalDate.parse(data,formatter);
  }

  public static String converteLocalDateParaString(LocalDate data, String formato){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
    return data.format(formatter);
  }

  public static LocalDateTime converteStringParaLocalDateTime(String data, String formato){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato, Locale.US);
    return LocalDateTime.parse(data,formatter);
  }

  public static String converteLocalDateTimeParaString(LocalDateTime data, String formato){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
    return data.format(formatter);
  }

}
