package org.example.utils;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleUtils {
  private final Scanner scanner = new Scanner(System.in);

  public String getString(String message){
    System.out.println(message);
    return scanner.nextLine().trim().toLowerCase();
  }
  public Integer getInteger(String message){
    try{
      System.out.println(message);
      int value = scanner.nextInt();
      scanner.nextLine();

      if(value < 0){
        System.out.println("Ingresa un número positivo.");
        return getInteger(message);
      }
      return value;
    }catch(Exception e){
      System.out.println("Ingresa un número con formato válido.");
      scanner.nextLine();
      return getInteger(message);
    }
  }
}
