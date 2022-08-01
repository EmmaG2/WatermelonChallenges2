package com.challenges;

import java.util.*;

public class Week2
{

  public static void startDay8()
  {
    int widthHeight = sc.nextInt();
    int[][] array2D = new int[widthHeight][widthHeight];

    for (int i = 0; i < widthHeight; i++)
      for (int j = 0; j < widthHeight; j++)
        array2D[i][j] = sc.nextInt();

    System.out.println(logicDay8(array2D) ? "YES" : "NO");
  }

  private static boolean logicDay8(int[][] matriz)
  {
    if (matriz[0][0] != 1)
      for (int i = 0, j = matriz.length - 1; i < matriz.length; i++, j--)
        if (matriz[i][j] != 1)
          return false;

    if (matriz[0][0] == 1)
      for (int i = 0, j = 0; i < matriz.length; i++, j++)
        if (matriz[i][j] != 1)
          return false;

    return true;
  }

  public static void startDay9()
  {
    Set<Integer> numbers = new TreeSet<>();
    int          quantityNumbers, i;

    quantityNumbers = sc.nextInt();

    for (i = 0; i < quantityNumbers; i++)
      numbers.add(sc.nextInt());

    numbers.forEach(n -> System.out.print(n + " "));
  }

  /**
   *
   */
  public static void startDay10()
  {
    Queue<Integer> cola = new LinkedList<Integer>();
    Stack<Integer> pila = new Stack<>();
    int            numberOfElements;

    numberOfElements = sc.nextInt();

    for (int i = 0; i < numberOfElements; i++)
    {
      int numberToPush = sc.nextInt();
      cola.add(numberToPush);
      pila.push(numberToPush);
    }

    System.out.println("Cola ->");
    for (int i = 0; i < numberOfElements; i++)
    {
      System.out.print(cola.remove() + " ");
    }

    System.out.println("\nStack ->");
    for (int i = 0; i < numberOfElements; i++)
    {
      System.out.print(pila.pop() + " ");
    }
  }

  public static void startDay11()
  {
    int userNumberInput;
    userNumberInput = sc.nextInt();
    char output     = (char)userNumberInput;

    System.out.println(output);
  }

  public static void startDay12()
  {
    char[] word = requestAWord();

    reverseInput(word);

    printOutputInScreen(word);
  }

  private static char[] requestAWord()
  {
    final int ASCII_MIN_UPPER = 65;
    final int ASCII_MAX_UPPER = 97;

    String userInput = sc.nextLine();
    char   AsciiCode = userInput.charAt(0);

    isUpperCase(ASCII_MIN_UPPER, ASCII_MAX_UPPER, AsciiCode);

    char[] reverseWord = userInput.toCharArray();
    return reverseWord;
  }

  private static void isUpperCase(final int asciiMin, final int asciiUpper,
                                  char AsciiCode)
  {
    System.out.println(
        (AsciiCode >= asciiMin && AsciiCode < asciiUpper ? "is Upper" : "is Lower"));
  }

  private static void reverseInput(char[] reverseWord)
  {
    final int ASCII_DIFFERENCE = 32;

    for (int i = 0; i < reverseWord.length; i++)
    {
      if (reverseWord[i] >= 'A' && reverseWord[i] <= 'Z')
        reverseWord[i] = (char)((int)reverseWord[i] + ASCII_DIFFERENCE);
      else if (reverseWord[i] >= 'a' && reverseWord[i] <= 'z')
        reverseWord[i] = (char)((int)reverseWord[i] - ASCII_DIFFERENCE);
    }
  }

  private static void printOutputInScreen(char[] reverseWord)
  {
    for (int i = 0; i < reverseWord.length; i++)
    {
      System.out.print(reverseWord[i]);
    }
  }

  public static void startDay13()
  {
    String input = sc.nextLine();

    String[] verificarParentesis = {"(", ")"};
    String[] verificarCorchetes  = {"[", "]"};

    boolean isCorrectParentesis = verifyIfInputIsCorrect(verificarParentesis, input);
    boolean isCorrectCorchetes  = verifyIfInputIsCorrect(verificarCorchetes, input);

    System.out.println((isCorrectParentesis || isCorrectCorchetes ? "YES" : "NO"));
  }

  private static boolean verifyIfInputIsCorrect(String[] arrInput, String input)
  {
    for (String item : arrInput)
      if (!input.contains(item) || input.length() % 2 != 0)
        return false;

    return true;
  }

  public static void startDay14()
  {
    int numContultas    = sc.nextInt();
    int opcionARealizar = 0;

    HashMap<String, Integer> alumnos = new HashMap<String, Integer>();

    programLogic(numContultas, alumnos);
  }

  private static void programLogic(int numContultas, HashMap<String, Integer> alumnos)
  {
    int opcionARealizar;
    for (int i = 0; i < numContultas; i++)
    {
      opcionARealizar = sc.nextInt();
      String nombre   = sc.next();
      int    calif;

      if (opcionARealizar == 3)
      {
        System.out.println(alumnos.get(nombre));
        continue;
      }
      else
      {
        calif = sc.nextInt();
      }

      if (opcionARealizar == 1)
      {
        alumnos.put(nombre, alumnos.getOrDefault(nombre, 0) + calif);
      }

      if (opcionARealizar == 2)
      {
        alumnos.remove(nombre);
      }
    }
  }

  public static Scanner sc = new Scanner(System.in);
}
