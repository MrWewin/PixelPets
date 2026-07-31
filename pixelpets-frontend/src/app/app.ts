import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MascotaList } from './components/mascota-list/mascota-list';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, MascotaList],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('pixelpets-frontend');
}