package com.streaming.service;

import com.streaming.model.Cancion;
import com.streaming.model.Genero;
import com.streaming.repository.CancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class CancionService {

    @Autowired
    private CancionRepository repo;

    @PostConstruct
    public void init() {
        repo.findAll().add(new Cancion("Tema1", "A", Genero.ROCK));
        repo.findAll().add(new Cancion("Tema2", "B", Genero.POP));
        repo.findAll().add(new Cancion("Tema3", "A", Genero.ROCK));
    }

    public List<Cancion> getAll() {
        return repo.findAll();
    }

    public Optional<Cancion> getById(String id) {
        return repo.findAll().stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    public void reproducir(String id) {
        getById(id).ifPresent(Cancion::reproducir);
    }

   public List<Cancion> top10() {
    return repo.findAll().stream()
            .sorted(Comparator.comparing((Cancion c) -> c.getReproducciones().get()).reversed())
            .limit(10)
            .toList();
}
}