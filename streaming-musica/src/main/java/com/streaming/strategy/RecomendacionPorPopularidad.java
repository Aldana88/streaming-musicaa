package com.streaming.strategy;

import com.streaming.model.Cancion;
import java.util.Comparator;
import java.util.List;

public class RecomendacionPorPopularidad implements RecomendacionStrategy {

    @Override
    public List<Cancion> recomendar(List<Cancion> catalogo, Cancion base) {
        return catalogo.stream()
                .sorted(Comparator.comparing((Cancion c) -> c.getReproducciones().get()).reversed())
                .limit(5)
                .toList();
    }
}