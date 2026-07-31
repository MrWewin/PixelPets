package com.pixelpets.pixelpets_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pixelpets.pixelpets_backend.model.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {

    // Buscar por nombre (contiene, sin importar mayúsculas/minúsculas)
    List<Mascota> findByNombreContainingIgnoreCase(String nombre);

    // Filtrar por especie exacta (sin importar mayúsculas/minúsculas)
    List<Mascota> findByEspecieIgnoreCase(String especie);

    // Filtrar por rareza exacta (sin importar mayúsculas/minúsculas)
    List<Mascota> findByRarezaIgnoreCase(String rareza);

    // Ordenar por precio ascendente
    List<Mascota> findAllByOrderByPrecioAsc();

    // Ordenar por precio descendente
    List<Mascota> findAllByOrderByPrecioDesc();
}