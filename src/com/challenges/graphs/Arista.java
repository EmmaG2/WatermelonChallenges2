package com.challenges.graphs;

public class Arista implements Comparable<Arista> {
  private final Vertice vertice1;
  private final Vertice vertice2;
  private int peso;

  public Arista(Vertice vertice1, Vertice vertice2) {
    this(vertice1, vertice2, 1);
  }

  public Arista(Vertice vertice1, Vertice vertice2, int peso) {
    if (vertice1.getEtiqueta().compareTo(vertice2.getEtiqueta()) <= 0) {
      this.vertice1 = vertice1;
      this.vertice2 = vertice2;
    } else {
      this.vertice1 = vertice2;
      this.vertice2 = vertice1;
    }
    this.peso = peso;
  }

  public Vertice getVecinoDe(Vertice actual) {
    if (actual.equals(this.vertice1)) return this.vertice2;
    if (actual.equals(this.vertice2)) return this.vertice1;

    return null;
  }

  public Vertice getVertice1() {
    return this.vertice1;
  }

  public Vertice getVertice2() {
    return this.vertice2;
  }

  public int getPeso() {
    return this.peso;
  }

  public void setPeso(int peso) {
    this.peso = peso;
  }

  public int compareTo(Arista arista2) {
    return this.peso - arista2.peso;
  }

  public String toString() {
    return "({" + this.vertice1 + ", " + this.vertice2 + "}, " + this.peso + ")";
  }

  public int hashCode() {
    return (vertice1.getEtiqueta() + vertice2.getEtiqueta()).hashCode();
  }

  public boolean equals(Arista objeto) {
    if (objeto == null) return false;

    return ((Arista) objeto).vertice1.equals(this.vertice1) && ((Arista) objeto).vertice2.equals(this.vertice2);
  }
}