package com.streaming.service;

import com.streaming.model.Cancion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcurrenciaService {

   
    public void simularReproducciones(List<Cancion> canciones) {

        Runnable tarea = () -> {
            for (Cancion c : canciones) {
                c.getReproducciones().incrementAndGet();
            }
        };

       
        Thread hilo1 = new Thread(tarea);
        Thread hilo2 = new Thread(tarea);
        Thread hilo3 = new Thread(tarea);

        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}