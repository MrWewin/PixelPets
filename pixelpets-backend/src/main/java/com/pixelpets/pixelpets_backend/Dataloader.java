package com.pixelpets.pixelpets_backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.pixelpets.pixelpets_backend.model.Mascota;
import com.pixelpets.pixelpets_backend.repository.MascotaRepository;

@Component
public class Dataloader implements CommandLineRunner {

    private final MascotaRepository mascotaRepository;

    public Dataloader(MascotaRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }

    @Override
    public void run(String... args) {

        if (mascotaRepository.count() == 0) {

            mascotaRepository.save(new Mascota(
                    null,
                    "Drako",
                    "Dragón",
                    "Legendaria",
                    5000,
                    100));

            mascotaRepository.save(new Mascota(
                    null,
                    "Luna",
                    "Gato",
                    "Común",
                    200,
                    90));

            mascotaRepository.save(new Mascota(
                    null,
                    "Rex",
                    "Lobo",
                    "Épica",
                    1800,
                    95));

            mascotaRepository.save(new Mascota(
                    null,
                    "Spark",
                    "Zorro",
                    "Rara",
                    900,
                    80));
        }
    }
}