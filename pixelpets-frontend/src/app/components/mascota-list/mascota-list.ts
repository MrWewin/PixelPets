import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Mascota } from '../../models/mascota';
import { MascotaService } from '../../services/mascota.service';

@Component({
  selector: 'app-mascota-list',
  imports: [CommonModule, FormsModule],
  templateUrl: './mascota-list.html',
  styleUrl: './mascota-list.css'
})
export class MascotaList implements OnInit {
  mascotas: Mascota[] = [];
  nombreBusqueda: string = '';
  especieSeleccionada: string = '';
  rarezaSeleccionada: string = '';

  especies: string[] = ['Dragón', 'Gato', 'Lobo', 'Zorro'];
  rarezas: string[] = ['Común', 'Rara', 'Épica', 'Legendaria'];

  constructor(private mascotaService: MascotaService) {}

  ngOnInit(): void {
    this.cargarTodas();
  }

  cargarTodas(): void {
    this.mascotaService.obtenerTodas().subscribe({
      next: (data) => (this.mascotas = data),
      error: (err) => console.error('Error al cargar mascotas:', err)
    });
  }

  buscar(): void {
    if (!this.nombreBusqueda.trim()) {
      this.cargarTodas();
      return;
    }
    this.mascotaService.buscarPorNombre(this.nombreBusqueda).subscribe({
      next: (data) => (this.mascotas = data),
      error: (err) => console.error('Error al buscar:', err)
    });
  }

  filtrarPorEspecie(): void {
    if (!this.especieSeleccionada) {
      this.cargarTodas();
      return;
    }
    this.mascotaService.filtrarPorEspecie(this.especieSeleccionada).subscribe({
      next: (data) => (this.mascotas = data),
      error: (err) => console.error('Error al filtrar por especie:', err)
    });
  }

  filtrarPorRareza(): void {
    if (!this.rarezaSeleccionada) {
      this.cargarTodas();
      return;
    }
    this.mascotaService.filtrarPorRareza(this.rarezaSeleccionada).subscribe({
      next: (data) => (this.mascotas = data),
      error: (err) => console.error('Error al filtrar por rareza:', err)
    });
  }

  ordenarAscendente(): void {
    this.mascotaService.ordenarAscendente().subscribe({
      next: (data) => (this.mascotas = data),
      error: (err) => console.error('Error al ordenar:', err)
    });
  }

  ordenarDescendente(): void {
    this.mascotaService.ordenarDescendente().subscribe({
      next: (data) => (this.mascotas = data),
      error: (err) => console.error('Error al ordenar:', err)
    });
  }

  limpiarFiltros(): void {
    this.nombreBusqueda = '';
    this.especieSeleccionada = '';
    this.rarezaSeleccionada = '';
    this.cargarTodas();
  }
}
