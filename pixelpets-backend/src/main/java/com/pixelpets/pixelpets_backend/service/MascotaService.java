package com.pixelpets.pixelpets_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pixelpets.pixelpets_backend.model.Mascota;
import com.pixelpets.pixelpets_backend.repository.MascotaRepository;

@Service
public class MascotaService {

    private final MascotaRepository mascotaRepository;

    public MascotaService(MascotaRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }

    public List<Mascota> obtenerTodasLasMascotas() {
        return mascotaRepository.findAll();
    }

    public Mascota guardarMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    public List<Mascota> buscarPorNombre(String nombre) {
        return mascotaRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public List<Mascota> filtrarPorEspecie(String especie) {
        return mascotaRepository.findByEspecieIgnoreCase(especie);
    }

    public List<Mascota> filtrarPorRareza(String rareza) {
        return mascotaRepository.findByRarezaIgnoreCase(rareza);
    }

    public List<Mascota> ordenarPorPrecioAscendente() {
        return mascotaRepository.findAllByOrderByPrecioAsc();
    }

    public List<Mascota> ordenarPorPrecioDescendente() {
        return mascotaRepository.findAllByOrderByPrecioDesc();
    }
}