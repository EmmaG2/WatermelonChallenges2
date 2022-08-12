package com.challenges.graphs;

import java.util.ArrayList;

public class Vertice {

  private final ArrayList<Arista> vecindad;
  private final String etiqueta;

  public Vertice(String etiqueta) {
    this.etiqueta = etiqueta;
    this.vecindad = new ArrayList<Arista>();
  }

  public Vertice() {
    this.etiqueta = "";
    this.vecindad = new ArrayList<Arista>();
  }

  public void insertarVecino(Arista arista) {
    if (!this.vecindad.contains(arista)) this.vecindad.add(arista);
  }

  public boolean contieneUnVecino(Arista arista) {
    return this.vecindad.contains(arista);
  }

  public Arista getVecino(int indice) {
    return this.vecindad.get(indice);
  }

  public Arista eliminarVecino(int indice) {
    return this.vecindad.remove(indice);
  }

  public void eliminarVecino(Arista arista) {
    this.vecindad.remove(arista);
  }

  public int getContarVecinos() {
    return this.vecindad.size();
  }

  public String getEtiqueta() {
    return this.etiqueta;
  }

  public boolean equals(Object vertice2) {
    if (!(vertice2 instanceof Vertice v)) return false;

    return this.etiqueta.equals(v.etiqueta);
  }

  public String toString() {
    return "Vertice: " + this.etiqueta;
  }

  public int hashCode() {
    return this.getEtiqueta().hashCode();
  }

  public ArrayList<Arista> getVecinos() {
    return new ArrayList<Arista>(this.vecindad);
  }
}
