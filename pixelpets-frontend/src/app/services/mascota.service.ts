import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Mascota } from '../models/mascota';

@Injectable({
  providedIn: 'root'
})
export class MascotaService {
  private readonly apiUrl = 'http://localhost:8080/mascotas';

  constructor(private http: HttpClient) {}

  obtenerTodas(): Observable<Mascota[]> {
    return this.http.get<Mascota[]>(this.apiUrl);
  }

  buscarPorNombre(nombre: string): Observable<Mascota[]> {
    return this.http.get<Mascota[]>(`${this.apiUrl}/buscar`, {
      params: { nombre }
    });
  }

  filtrarPorEspecie(especie: string): Observable<Mascota[]> {
    return this.http.get<Mascota[]>(`${this.apiUrl}/especie/${especie}`);
  }

  filtrarPorRareza(rareza: string): Observable<Mascota[]> {
    return this.http.get<Mascota[]>(`${this.apiUrl}/rareza/${rareza}`);
  }

  ordenarAscendente(): Observable<Mascota[]> {
    return this.http.get<Mascota[]>(`${this.apiUrl}/orden/asc`);
  }

  ordenarDescendente(): Observable<Mascota[]> {
    return this.http.get<Mascota[]>(`${this.apiUrl}/orden/desc`);
  }
}