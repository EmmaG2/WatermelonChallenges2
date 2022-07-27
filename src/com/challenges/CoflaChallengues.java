package com.challenges;

import java.util.Scanner;

/**
 * Esta clase está echa para crar las soluciones del curso de Dalto
 * ! El curso de Dalto est´á echo en javascript pero yo utilizaré JAVA
 *
 *
 * @author Emma
 * @version
 */
public class CoflaChallengues
{
  static int hour = 0;

  public static void main( String[] args )
  {
    startChallenge2();
    CoflaChallengues.hour += 1;
    startChallenge2();
    CoflaChallengues.hour += 1;
    startChallenge2();
    CoflaChallengues.hour += 1;
    startChallenge2();
    CoflaChallengues.hour += 1;
    startChallenge2();
    CoflaChallengues.hour += 1;
    startChallenge2();
  }

  /**
   * // Desafio 2
   *
   *  Dejar pasar solo a mayores de 18
   *  El primero que entre despues de las 2 am no paga
   *
   * @author Emma
   * @version
   */
  public static void startChallenge2()
  {
    Scanner sc = new Scanner( System.in );
    int     age;

    System.out.println( "Ingresa tu edad:" );
    age = sc.nextInt();

    System.out.println( allowJoin( age, hour ) );
  }

  private static String allowJoin( int age, int hour )
  {
    if ( age >= 18 && hour == 2 )
    {
      hour += 1;
      return "Eres mayor, bienvenido a la fiesta, no pagas entrada";
    }

    if ( age >= 18 )
    {
      return "Puedes entrar, pero tienes que pagar";
    }

    hour += 1;
    return "Vete a tu casa bebito";
  }
}
