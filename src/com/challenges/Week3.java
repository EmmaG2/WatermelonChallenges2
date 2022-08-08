package com.challenges;

import java.util.*;
import java.util.stream.Collectors;

public class Week3
{
  public static void startDay15()
  {
    String string    = sc.next();
    String[] numbers = string.split("\\+");

    String sortedNums = Arrays.stream(numbers).sorted().collect(Collectors.joining("+"));

    System.out.println(sortedNums);
  }

  public static void startDay16()
  {
    final int           input  = sc.nextInt();
    LinkedList<Integer> ninios = new LinkedList<>();

    if (input >= (2 * Math.pow(10, 5)) - input || input < 0)
    {
      System.out.println("Entrada invalida");
      return;
    }

    for (int i = 0; i < input; i++)
      ninios.add((i + 1));

    do
    {
      ninios.addLast(ninios.get(0));
      ninios.remove(ninios.getFirst());
      System.out.print(ninios.get(0) + " ");
      ninios.remove(ninios.getFirst());
    } while (ninios.size() > 1);

    System.out.print(ninios.get(0));
  }

  public static void startDay17()
  {
    int           sequenceLength = sc.nextInt();
    int           changes        = 0;
    List<Integer> sequence       = new ArrayList<>();
    List<Integer> removidos      = new ArrayList<>();

    for (int i = 0; i < sequenceLength; i++)
      sequence.add(sc.nextInt());

    for (int number : sequence)
    {
      if (removidos.contains(number))
        continue;

      if (Collections.frequency(sequence, number) > number)
        changes += (Collections.frequency(sequence, number) - number);
      if (Collections.frequency(sequence, number) < number)
        changes += Collections.frequency(sequence, number);

      removidos.add(number);
    }

    System.out.println(changes);
  }

  public static void startDay18()
  {
    int cantidadCanicas;
    int cantidadConsultas;
    int numCases = 0;

    do
    {
      cantidadCanicas         = sc.nextInt();
      cantidadConsultas       = sc.nextInt();
      List<Integer> canicas   = new ArrayList<>();
      List<Integer> consultas = new ArrayList<>();

      relleranInfo(cantidadCanicas, cantidadConsultas, canicas, consultas);
      numCases = getNumCases(numCases, canicas);
      printIfFounded(canicas, consultas);

    } while (cantidadCanicas != 0 && cantidadConsultas != 0);
  }

  private static void printIfFounded(List<Integer> canicas, List<Integer> consultas)
  {
    for (int numConsulta : consultas)
    {
      if (canicas.contains(numConsulta))
        System.out.println(numConsulta + " found at " +
                           (canicas.indexOf(numConsulta) + 1));
      else
        System.out.println(numConsulta + " not found");
    }
  }

  private static int getNumCases(int numCases, List<Integer> canicas)
  {
    Collections.sort(canicas);
    numCases++;
    System.out.println("\nCASE #" + numCases);
    return numCases;
  }

  private static void relleranInfo(int cantidadCanicas, int cantidadConsultas,
                                   List<Integer> canicas, List<Integer> consultas)
  {
    for (int i = 0; i < cantidadCanicas; i++)
      canicas.add(sc.nextInt());
    for (int i = 0; i < cantidadConsultas; i++)
      consultas.add(sc.nextInt());
  }

  public static void startDay18Dot5()
  {
    StringBuilder message = new StringBuilder();
    int           cities  = sc.nextInt();

    for (int i = 0; i < cities; i++)
    {
      List<Integer> list = new ArrayList<>();
      int           p    = sc.nextInt();

      for (int j = 0; j < p; j++)
      {
        list.add(sc.nextInt());
        list.add(sc.nextInt());
      }

      if (list.size() > 2)
        message.append("1\n");
      else
        message.append("0\n");
    }

    System.out.println(message);
  }

  public static void startDay19()
  {
    int           consultas = sc.nextInt();
    StringBuilder mensaje   = new StringBuilder("");

    for (int i = 0; i < consultas; i++)
    {
      int           granero    = sc.nextInt();
      int           vacasLocas = sc.nextInt();
      List<Integer> ubicacion  = new ArrayList<>();

      addCows(granero, ubicacion);

      getDistance(mensaje, granero, vacasLocas, ubicacion);
    }

    System.out.println(mensaje);
  }

  private static void getDistance(StringBuilder mensaje, int granero, int vacasLocas,
                                  List<Integer> ubicacion)
  {
    int maximaDistancia = ubicacion.get(granero - 1) - ubicacion.get(0);
    int distancia       = Integer.MIN_VALUE;
    for (int k = 1; k <= maximaDistancia; k++)
      if (isCompatible(ubicacion, k, vacasLocas))
        distancia = Math.max(distancia, k);
    mensaje.append(distancia).append("\n");
  }

  private static void addCows(int granero, List<Integer> ubicacion)
  {
    for (int j = 0; j < granero; j++)
      ubicacion.add(sc.nextInt());
    Collections.sort(ubicacion);
  }

  static boolean isCompatible(List<Integer> ubicacion, int distancia, int vacasLocas)
  {
    int vacas = ubicacion.size();
    int vaca  = ubicacion.get(0);
    vacasLocas--;
    for (int i = 1; i < vacas; i++)
    {
      if (ubicacion.get(i) - vaca >= distancia)
      {
        vacasLocas--;
        if (vacasLocas == 0)
          return true;
        vaca = ubicacion.get(i);
      }
    }
    return false;
  }

  public static void startDay20()
  {
    int                             moviesQuantity = sc.nextInt();
    LinkedList<LinkedList<Integer>> moviesHours    = new LinkedList<>();
    List<LinkedList<Integer>>       moviesToWatch  = new ArrayList<>();

    for (int i = 0; i < moviesQuantity; i++)
    {
      LinkedList<Integer> moviesStartAndEndHours = new LinkedList<>();
      moviesStartAndEndHours.add(sc.nextInt());
      moviesStartAndEndHours.add(sc.nextInt());
      moviesHours.add(moviesStartAndEndHours);
    }

    for (LinkedList<Integer> horario : moviesHours)
    {
      if (horario.getLast() > horario.getFirst() &&
          (horario.getLast() - horario.getFirst()) <= 3)
      {
        moviesToWatch.add(horario);
      }
    }

    System.out.println(moviesToWatch.size());
  }

  public static void startDay21()
  {
    StringBuilder output = new StringBuilder("");

    int           compartimentos                 = sc.nextInt();
    int           fragmentos                     = sc.nextInt();
    List<Integer> compartimentoParaCadaFragmento = new ArrayList<>();

    addFragmento(compartimentos, compartimentoParaCadaFragmento);

    getDistanceEntreFragmentos(output, compartimentos, fragmentos,
                               compartimentoParaCadaFragmento);

    System.out.println(output);
  }

  private static void addFragmento(int           compartimentos,
                                   List<Integer> compartimentoParaCadaFragmento)
  {
    for (int j = 0; j < compartimentos; j++)
      compartimentoParaCadaFragmento.add(sc.nextInt());
    Collections.sort(compartimentoParaCadaFragmento);
  }

  private static void getDistanceEntreFragmentos(
      StringBuilder output, int compartimentos, int fragmentos,
      List<Integer> compartimentoParaCadaFragmento)
  {
    int maximaDistancia = compartimentoParaCadaFragmento.get(compartimentos - 1) -
                          compartimentoParaCadaFragmento.get(0);
    int distancia = 0;
    for (int k = 1; k <= maximaDistancia; k++)
      if (fragmentoIsCompatible(compartimentoParaCadaFragmento, k, fragmentos))
        distancia = Math.max(distancia, k);

    output.append(distancia).append("\n");
  }

  static boolean fragmentoIsCompatible(List<Integer> compartimentoParaCadaFragmento,
                                       int distancia, int fragmentos)
  {
    int compartimentos = compartimentoParaCadaFragmento.size();
    int compartimento  = compartimentoParaCadaFragmento.get(0);
    fragmentos--;
    for (int i = 1; i < compartimentos; i++)
    {
      if (compartimentoParaCadaFragmento.get(i) - compartimento >= distancia)
      {
        fragmentos--;
        if (fragmentos == 0)
          return true;
        compartimento = compartimentoParaCadaFragmento.get(i);
      }
    }
    return false;
  }

  public static Scanner sc = new Scanner(System.in);
}
