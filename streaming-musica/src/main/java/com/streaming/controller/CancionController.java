package com.streaming.controller;

import com.streaming.model.Cancion;
import com.streaming.service.CancionService;
import com.streaming.service.BusquedaOrdenamientoService;
import com.streaming.service.PlaylistService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/canciones")
public class CancionController {

    @Autowired
    private CancionService service;

    @Autowired
    private BusquedaOrdenamientoService ordenService;

    @Autowired
    private PlaylistService playlistService;

    // 📌 Listar todas
    @GetMapping
    public List<Cancion> listar() {
        return service.getAll();
    }

    // 📌 Top 10 más reproducidas
    @GetMapping("/top10")
    public List<Cancion> top10() {
        return service.top10();
    }

    // 📌 Ordenadas por artista y fecha
    @GetMapping("/ordenadas")
    public List<Cancion> ordenar() {
        return ordenService.ordenarPorArtistaYFecha();
    }

    // 🔥 Playlist automática (mochila)
    @GetMapping("/playlist")
    public List<Cancion> playlist(@RequestParam int minutos) {
        return playlistService.generarPlaylist(service.getAll(), minutos);
    }

    // 🔍 Búsqueda binaria por título
    @GetMapping("/buscar-binaria")
    public Cancion buscarBinaria(@RequestParam String titulo) {
        return ordenService.busquedaBinariaPorTitulo(titulo);
    }

    // ▶️ Reproducir canción
    @PostMapping("/{id}/reproducir")
    public ResponseEntity<Void> reproducir(@PathVariable String id) {
        service.reproducir(id);
        return ResponseEntity.ok().build();
    }
}