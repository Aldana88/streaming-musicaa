package com.streaming.service;

import com.streaming.model.Cancion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaylistService {

    public List<Cancion> generarPlaylist(List<Cancion> canciones, int minutos) {
        return backtracking(canciones, minutos * 60, 0, new ArrayList<>(), 0);
    }

    private List<Cancion> backtracking(List<Cancion> canciones, int objetivo, int index,
                                       List<Cancion> actual, int suma) {

        if (suma == objetivo) return new ArrayList<>(actual);

        if (suma > objetivo || index >= canciones.size()) return new ArrayList<>();

        actual.add(canciones.get(index));

        List<Cancion> resultado = backtracking(
                canciones,
                objetivo,
                index + 1,
                actual,
                suma + canciones.get(index).getDuracionSegundos()
        );

        if (!resultado.isEmpty()) return resultado;

        actual.remove(actual.size() - 1);

        return backtracking(canciones, objetivo, index + 1, actual, suma);
    }
}