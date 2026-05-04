package com.streaming.strategy;

import com.streaming.model.Cancion;
import java.util.Comparator;
import java.util.List;

public class RecomendacionPorGenero implements RecomendacionStrategy {

    @Override
    public List<Cancion> recomendar(List<Cancion> catalogo, Cancion base) {
        return catalogo.stream()
                .filter(c -> c.getGenero() == base.getGenero())
                .sorted(Comparator.comparing(Cancion::getRating).reversed())
                .toList();
    }
}