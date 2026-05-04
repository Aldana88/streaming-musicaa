package com.streaming.repository;

import com.streaming.model.Cancion;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CancionRepository {

    private List<Cancion> canciones = new ArrayList<>();

    public List<Cancion> findAll() {
        return canciones;
    }
}