package com.streaming.strategy;

import com.streaming.model.Cancion;
import java.time.LocalDate;
import java.util.List;

public class RecomendacionDescubrimiento implements RecomendacionStrategy {

    @Override
    public List<Cancion> recomendar(List<Cancion> catalogo, Cancion base) {
        return catalogo.stream()
                .filter(c -> c.getReproducciones().get() < 1000)
                .filter(c -> c.getFechaLanzamiento().isAfter(LocalDate.now().minusYears(2)))
                .toList();
    }
}