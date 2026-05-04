package com.streaming.strategy;

import com.streaming.model.Cancion;
import java.util.List;

public interface RecomendacionStrategy {
    List<Cancion> recomendar(List<Cancion> catalogo, Cancion base);
}