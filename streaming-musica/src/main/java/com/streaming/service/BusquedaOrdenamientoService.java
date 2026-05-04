package com.streaming.service;

import com.streaming.model.Cancion;
import com.streaming.repository.CancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class BusquedaOrdenamientoService {

    @Autowired
    private CancionRepository repo;

    // 🔎 BÚSQUEDA BINARIA
    public Cancion busquedaBinariaPorTitulo(String titulo) {
        List<Cancion> lista = repo.findAll().stream()
                .sorted((a, b) -> a.getTitulo().compareToIgnoreCase(b.getTitulo()))
                .toList();

        int left = 0, right = lista.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = lista.get(mid).getTitulo().compareToIgnoreCase(titulo);

            if (cmp == 0) return lista.get(mid);
            if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }

        return null;
    }

    // 📊 ORDENAMIENTO
    public List<Cancion> ordenarPorArtistaYFecha() {
        return repo.findAll().stream()
                .sorted(
                        Comparator.comparing((Cancion c) -> c.getArtista())
                                .thenComparing(c -> c.getFechaLanzamiento())
                                .reversed()
                )
                .toList();
    }
}