package com.streaming.model;

import java.time.LocalDate;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class Cancion {

    private String id;
    private String titulo;
    private String artista;
    private Genero genero;
    private int duracionSegundos;
    private AtomicInteger reproducciones;
    private double rating;
    private LocalDate fechaLanzamiento;

    public Cancion(String titulo, String artista, Genero genero) {
        this.id = UUID.randomUUID().toString();
        this.titulo = titulo;
        this.artista = artista;
        this.genero = genero;
        this.reproducciones = new AtomicInteger(0);
        this.rating = 4.0;
        this.duracionSegundos = 180;
        this.fechaLanzamiento = LocalDate.now();
    }

    public void reproducir() {
        reproducciones.incrementAndGet();
    }

    public String getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getArtista() { return artista; }
    public Genero getGenero() { return genero; }
    public int getDuracionSegundos() { return duracionSegundos; }
    public AtomicInteger getReproducciones() { return reproducciones; }
    public double getRating() { return rating; }
    public LocalDate getFechaLanzamiento() { return fechaLanzamiento; }
}