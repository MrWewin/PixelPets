package com.pixelpets.pixelpets_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pixelpets.pixelpets_backend.model.Mascota;
import com.pixelpets.pixelpets_backend.service.MascotaService;

@RestController
@RequestMapping("/mascotas")
@CrossOrigin(origins = "http://localhost:4200")
public class MascotaController {

    private final MascotaService mascotaService;

    public MascotaController(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    @GetMapping
    public List<Mascota> obtenerTodasLasMascotas() {
        return mascotaService.obtenerTodasLasMascotas();
    }

    @PostMapping
    public Mascota guardarMascota(@RequestBody Mascota mascota) {
        return mascotaService.guardarMascota(mascota);
    }

    // GET /mascotas/buscar?nombre=luna
    @GetMapping("/buscar")
    public List<Mascota> buscarPorNombre(@RequestParam String nombre) {
        return mascotaService.buscarPorNombre(nombre);
    }

    // GET /mascotas/especie/{especie}
    @GetMapping("/especie/{especie}")
    public List<Mascota> filtrarPorEspecie(@PathVariable String especie) {
        return mascotaService.filtrarPorEspecie(especie);
    }

    // GET /mascotas/rareza/{rareza}
    @GetMapping("/rareza/{rareza}")
    public List<Mascota> filtrarPorRareza(@PathVariable String rareza) {
        return mascotaService.filtrarPorRareza(rareza);
    }

    // GET /mascotas/orden/asc
    @GetMapping("/orden/asc")
    public List<Mascota> ordenarPorPrecioAscendente() {
        return mascotaService.ordenarPorPrecioAscendente();
    }

    // GET /mascotas/orden/desc
    @GetMapping("/orden/desc")
    public List<Mascota> ordenarPorPrecioDescendente() {
        return mascotaService.ordenarPorPrecioDescendente();
    }
}