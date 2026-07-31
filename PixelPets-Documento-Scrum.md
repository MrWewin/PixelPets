# Documento de Proyecto: PixelPets — Desarrollo con Marco de Trabajo Scrum

**Integrantes del equipo:**
- Edwin David Pedraza Orozco
- Gustavo Andrés Núñez Vega

**Repositorio del proyecto:** [https://github.com/MrWewin/PixelPets](https://github.com/MrWewin/PixelPets)

**Fecha de asignación:** 30 de julio de 2026, 11:00 a.m.
**Fecha de entrega:** 30 de julio de 2026, 10:00 p.m.
**Duración real del ejercicio:** 11 horas
**Equivalencia del ejercicio:** 1 hora = 1 día de trabajo → **Sprint de 11 días**

---

## 1. Introducción

Este documento presenta el desarrollo completo del proyecto **PixelPets**, una vitrina digital de mascotas coleccionables, utilizando el marco de trabajo **Scrum**. El proyecto fue asignado y desarrollado en una sola sesión de trabajo de 11 horas continuas, equivalentes a un Sprint de 11 días bajo la convención acordada para este ejercicio (1 hora = 1 día).

Se documentan aquí todos los artefactos y eventos exigidos por Scrum (Product Backlog, Sprint Planning, Sprint Backlog, Daily Scrum, Incremento, Sprint Review y Sprint Retrospective), junto con la justificación de cada decisión técnica tomada durante el desarrollo.

---

## 2. Descripción del problema

La tienda **PixelPets** vende mascotas digitales coleccionables, pero sus clientes se sienten abrumados al ver todo el catálogo en una única lista desordenada. Los usuarios necesitan:

- Buscar una mascota específica por su nombre, cuando ya la conocen.
- Filtrar el catálogo por especie (Dragón, Gato, Lobo, Zorro, etc.), útil para coleccionistas que buscan un tipo particular.
- Filtrar por nivel de rareza (Común, Rara, Épica, Legendaria), ya que el valor coleccionable depende de este atributo.
- Ordenar el catálogo por precio, tanto para encontrar opciones económicas como piezas exclusivas de alto valor.

El objetivo del proyecto es resolver este problema de sobrecarga de información mediante una aplicación web con búsqueda, filtros y ordenamiento, que permita a cualquier cliente encontrar su mascota ideal de forma rápida e intuitiva.

---

## 3. Product Goal (Objetivo del Producto)

> Construir una vitrina digital funcional e intuitiva para PixelPets, donde los clientes puedan localizar rápidamente la mascota que desean mediante búsqueda por nombre, filtros por especie y rareza, y ordenamiento por precio — todo esto sobre una arquitectura cliente-servidor real (API REST + interfaz web) que demuestre buenas prácticas de ingeniería de software.

---

## 4. Roles Scrum

| Rol | Responsable | Responsabilidades |
|---|---|---|
| **Product Owner** | Gustavo Andrés Núñez Vega | Representa las necesidades de la tienda PixelPets, define y prioriza el Product Backlog, valida que cada incremento cumpla lo solicitado en el caso práctico. |
| **Scrum Master** | Edwin David Pedraza Orozco | Vela por el cumplimiento del marco Scrum dentro del tiempo límite de 11 horas, elimina bloqueos técnicos (errores de configuración, dependencias, conexión backend-frontend) y facilita el avance continuo del equipo. |
| **Equipo de Desarrollo** | Edwin David Pedraza Orozco y Gustavo Andrés Núñez Vega | Diseñan, implementan y prueban el backend (Spring Boot) y el frontend (Angular). Ambos colaboran en todas las etapas, aunque cada uno compromete un caso de uso individual (ver sección 8). |

---

## 5. Product Backlog

| ID | Historia de Usuario | Prioridad |
|---|---|---|
| HU1 | Como cliente quiero visualizar todas las mascotas disponibles para conocer el catálogo completo. | Alta |
| HU2 | Como cliente quiero buscar una mascota por su nombre para encontrarla rápidamente si ya la conozco. | Alta |
| HU3 | Como cliente quiero filtrar el catálogo por especie para ver únicamente el tipo de mascota que me interesa. | Alta |
| HU4 | Como cliente quiero filtrar por nivel de rareza para encontrar mascotas coleccionables especiales. | Alta |
| HU5 | Como cliente quiero ordenar el catálogo por precio ascendente para ver primero las opciones más económicas. | Media |
| HU6 | Como cliente quiero ordenar el catálogo por precio descendente para ver primero las piezas más exclusivas. | Media |

**Criterios de aceptación generales (aplican a HU1–HU6):**
- Cada mascota debe mostrar: ID, nombre, especie, rareza, precio y estado de salud.
- Las respuestas del backend deben ser en formato JSON, consumibles por el frontend.
- La interfaz debe actualizarse sin necesidad de recargar la página (SPA).

---

## 6. Sprint Planning

**Duración del Sprint:** 11 horas reales (30 de julio de 2026, 11:00 a.m. – 10:00 p.m.) = **11 días** bajo la convención del ejercicio.

**Sprint Goal:**
> Entregar, al final de las 11 horas, una aplicación web funcional de dos capas (API REST en Spring Boot + interfaz en Angular) que permita listar, buscar, filtrar y ordenar mascotas, con el código publicado en GitHub.

**Historias seleccionadas para este único Sprint:** HU1, HU2, HU3, HU4, HU5, HU6 (el backlog completo se cubre en este Sprint, dado que el proyecto completo debe entregarse en una sola sesión de clase).

**Justificación de la planificación:** Al tratarse de un ejercicio de una sola sesión, no es viable dividir el trabajo en múltiples Sprints; en su lugar, se aplicó una planificación de Sprint único con tareas secuenciadas por dependencia técnica (primero la capa de datos, luego la lógica de negocio, después la API, y finalmente la interfaz), priorizando siempre tener algo ejecutable en cada bloque de tiempo.

---

## 7. Sprint Backlog

| Tarea | Responsable | Horas (días) | Herramienta/Tecnología |
|---|---|---:|---|
| Configurar proyecto Spring Boot (estructura, dependencias) | Edwin | 1 | Spring Boot 4.1.0, Maven |
| Diseñar y crear el modelo `Mascota` (entidad JPA) | Edwin | 1 | Java 21, Jakarta Persistence |
| Crear `MascotaRepository`, `MascotaService` y `MascotaController` (listar y guardar) | Gustavo | 1 | Spring Data JPA |
| Implementar `DataLoader` con datos de prueba | Gustavo | 1 | CommandLineRunner |
| Implementar endpoint de búsqueda por nombre | Gustavo | 1 | Spring Data JPA (`findByNombreContainingIgnoreCase`) |
| Implementar endpoints de filtro por especie y rareza | Edwin | 1 | Spring Data JPA |
| Implementar endpoints de ordenamiento asc/desc | Edwin | 1 | Spring Data JPA |
| Configurar proyecto Angular y `HttpClient` | Ambos | 1 | Angular 22, TypeScript |
| Crear modelo, servicio y componente `mascota-list` | Ambos | 1 | Angular standalone components |
| Diseñar interfaz visual (tarjetas, buscador, filtros, botones) | Ambos | 1 | HTML, CSS |
| Pruebas de integración, corrección de errores (CORS, puertos, conexión) y despliegue a GitHub | Ambos | 1 | Postman/navegador, Git |

**Total: 11 tareas distribuidas en 11 horas (días).**

---

## 8. Caso de uso comprometido por cada integrante

### Edwin David Pedraza Orozco
**Caso de uso:** Filtrar mascotas por especie y por rareza, y ordenar el catálogo por precio (ascendente/descendente).

**Justificación:** Estos casos de uso requieren dominar las consultas derivadas de Spring Data JPA (`findByEspecieIgnoreCase`, `findByRarezaIgnoreCase`, `findAllByOrderByPrecioAsc/Desc`) y conectarlas correctamente con los controles de selección (`<select>`) y botones de ordenamiento en el frontend Angular.

### Gustavo Andrés Núñez Vega
**Caso de uso:** Mostrar el catálogo completo de mascotas y buscar por nombre.

**Justificación:** Este caso de uso cubre el flujo base de la aplicación (listar todas las mascotas al cargar la página) y la funcionalidad de búsqueda parcial e insensible a mayúsculas (`findByNombreContainingIgnoreCase`), que es el punto de entrada más usado por los clientes que ya conocen el nombre de la mascota que buscan.

> Ambos integrantes colaboraron en la configuración inicial del proyecto, el diseño de la interfaz, las pruebas de integración y la resolución de errores (por ejemplo, discrepancias de mayúsculas/minúsculas en nombres de archivo Java, procesos duplicados en el puerto 8080, y configuración de CORS entre Angular y Spring Boot).

---

## 9. Daily Scrum (11 días = 11 horas reales)

| Día | Horario real | Avance |
|---|---|---|
| **Día 1** | 11:00 a.m. – 12:00 p.m. | Sprint Planning. Se definió la arquitectura del proyecto (Spring Boot + Angular + H2) y se inicializaron ambos proyectos. |
| **Día 2** | 12:00 p.m. – 1:00 p.m. | Se creó el modelo `Mascota` con sus atributos (id, nombre, especie, rareza, precio, estadoSalud) y se configuró JPA. |
| **Día 3** | 1:00 p.m. – 2:00 p.m. | Se implementaron `MascotaRepository`, `MascotaService` y el `MascotaController` inicial (listar todas y guardar). |
| **Día 4** | 2:00 p.m. – 3:00 p.m. | Se creó el `DataLoader` con datos de prueba (Drako, Luna, Rex, Spark) y se resolvió un error de nomenclatura de archivo (`Dataloader.java` vs. clase `DataLoader`). |
| **Día 5** | 3:00 p.m. – 4:00 p.m. | Se implementó el endpoint de búsqueda por nombre (`/mascotas/buscar`). |
| **Día 6** | 4:00 p.m. – 5:00 p.m. | Se implementaron los endpoints de filtro por especie y rareza, y de ordenamiento ascendente/descendente. |
| **Día 7** | 5:00 p.m. – 6:00 p.m. | Se probaron todos los endpoints desde el navegador; se detectó y corrigió un problema de instancia duplicada en el puerto 8080. |
| **Día 8** | 6:00 p.m. – 7:00 p.m. | Se configuró Angular: `provideHttpClient`, modelo `Mascota` y `MascotaService` consumiendo la API. |
| **Día 9** | 7:00 p.m. – 8:00 p.m. | Se generó y programó el componente `mascota-list` (lógica de búsqueda, filtros y ordenamiento en TypeScript). |
| **Día 10** | 8:00 p.m. – 9:00 p.m. | Se diseñó la interfaz visual (tarjetas por rareza, barra de salud, buscador, selects y botones) y se integró en `app.html`. |
| **Día 11** | 9:00 p.m. – 10:00 p.m. | Pruebas finales de integración, corrección de errores de conexión, subida del proyecto completo a GitHub y cierre de la documentación Scrum. |

---

## 10. Desarrollo del producto

### Arquitectura implementada

**Backend (Spring Boot 4.1.0 + Java 21):**
- `model/Mascota.java` — entidad JPA con id, nombre, especie, rareza, precio y estadoSalud.
- `repository/MascotaRepository.java` — interfaz `JpaRepository` con métodos derivados: `findByNombreContainingIgnoreCase`, `findByEspecieIgnoreCase`, `findByRarezaIgnoreCase`, `findAllByOrderByPrecioAsc`, `findAllByOrderByPrecioDesc`.
- `service/MascotaService.java` — capa de lógica de negocio que expone cada operación del repositorio.
- `controller/MascotaController.java` — controlador REST con `@CrossOrigin` habilitado para `http://localhost:4200`.
- `Dataloader.java` — carga automática de datos de prueba al iniciar la aplicación (solo si la tabla está vacía).
- Base de datos: **H2 en memoria**, con creación automática de tablas vía Hibernate (`spring.jpa.hibernate.ddl-auto=update`).

**Endpoints disponibles:**

| Caso de uso | Endpoint |
|---|---|
| Mostrar todas las mascotas | `GET /mascotas` |
| Buscar por nombre | `GET /mascotas/buscar?nombre={texto}` |
| Filtrar por especie | `GET /mascotas/especie/{especie}` |
| Filtrar por rareza | `GET /mascotas/rareza/{rareza}` |
| Ordenar ascendente | `GET /mascotas/orden/asc` |
| Ordenar descendente | `GET /mascotas/orden/desc` |
| Guardar mascota | `POST /mascotas` |

**Frontend (Angular 22, standalone components):**
- `models/mascota.ts` — interfaz TypeScript que refleja la entidad del backend.
- `services/mascota.service.ts` — servicio con `HttpClient` que consume cada endpoint.
- `components/mascota-list/` — componente principal con:
  - Buscador de texto conectado al endpoint de búsqueda.
  - Selects de especie y rareza conectados a los endpoints de filtro.
  - Botones de ordenamiento ascendente/descendente.
  - Visualización en tarjetas, con color de borde según rareza y barra de salud con color según porcentaje.

**Control de versiones:** el proyecto completo (backend + frontend) se subió a un único repositorio en GitHub: [https://github.com/MrWewin/PixelPets](https://github.com/MrWewin/PixelPets), excluyendo `node_modules` y `target` mediante `.gitignore`.

---

## 11. Incremento

Al finalizar el Sprint de 11 días (11 horas reales), el incremento entregado es una **aplicación web funcional de dos capas**, verificada de extremo a extremo:

- ✅ Backend Spring Boot corriendo en el puerto 8080, con base de datos H2 poblada automáticamente.
- ✅ Los 6 endpoints funcionando y verificados (listar, buscar, filtrar por especie, filtrar por rareza, ordenar asc, ordenar desc).
- ✅ Frontend Angular corriendo en el puerto 4200, consumiendo la API en tiempo real.
- ✅ Interfaz visual completa, con retroalimentación clara (tarjetas, colores por rareza, barra de salud, mensaje de "sin resultados").
- ✅ Código fuente completo publicado en GitHub.

Este incremento representa el 100% del Product Backlog planificado para el Sprint (HU1 a HU6).

---

## 12. Sprint Review

Se realizó una demostración funcional de la aplicación, verificando en vivo cada historia de usuario:

- ✅ **HU1:** Al cargar la aplicación, se listaron correctamente las 4 mascotas de prueba (Drako, Luna, Rex, Spark).
- ✅ **HU2:** Se buscó "Luna" y "Drako" por nombre, obteniendo resultados correctos e insensibles a mayúsculas.
- ✅ **HU3:** Se filtró por especie "Gato", mostrando únicamente a Luna.
- ✅ **HU4:** Se filtró por rareza "Legendaria", mostrando únicamente a Drako.
- ✅ **HU5 y HU6:** Se ordenó el catálogo de menor a mayor precio (Luna → Spark → Rex → Drako) y de mayor a menor (orden inverso).

El Product Owner (Gustavo Andrés Núñez Vega) validó que las seis historias de usuario cumplen los criterios de aceptación definidos y que la aplicación resuelve el problema planteado en el caso práctico: evitar que el cliente vea todo el catálogo desordenado, dándole herramientas de búsqueda, filtro y orden.

---

## 13. Sprint Retrospective

### Lo que salió bien
- La división de tareas por capas (backend primero, frontend después) permitió tener avances verificables en cada bloque horario.
- La colaboración entre ambos integrantes resolvió rápidamente errores de configuración (nomenclatura de archivos, procesos duplicados en el puerto 8080, CORS).
- Se cumplió el Sprint Goal dentro del tiempo límite de 11 horas.

### Lo que puede mejorar
- Se perdió tiempo diagnosticando errores evitables (archivo `Dataloader.java` con minúscula, instancia vieja del backend ocupando el puerto 8080).
- Los filtros de especie, rareza y búsqueda no se combinan entre sí (cada uno sobrescribe al anterior), lo cual limita la experiencia de usuario.
- No se implementaron pruebas automatizadas (unitarias ni de integración) debido a la restricción de tiempo.

### Acciones para un siguiente Sprint (de tener continuidad)
- Combinar todos los filtros en una sola consulta parametrizada.
- Agregar pruebas unitarias al backend (JUnit) y al frontend (Jasmine/Karma).
- Migrar de H2 en memoria a una base de datos persistente (MySQL/MariaDB) si el proyecto continuara más allá de esta entrega.

---

## 14. Definición de Terminado (Definition of Done)

Una historia de usuario se considera terminada cuando:

1. El endpoint correspondiente en el backend responde correctamente en formato JSON.
2. El frontend consume ese endpoint y refleja el resultado en la interfaz sin recargar la página.
3. Se probó manualmente con al menos dos casos (uno con resultados, uno sin resultados).
4. No genera errores en la consola del navegador ni en la terminal del backend.
5. El código está subido al repositorio de GitHub del equipo.

---

## 15. Justificación de decisiones

### ¿Por qué Scrum?
Scrum permite dividir un proyecto en unidades de trabajo pequeñas y verificables (historias de usuario), lo cual es especialmente útil en un ejercicio de tiempo limitado como este: cada bloque de una hora ("día") entregó un avance comprobable, en vez de dejar todo el desarrollo para el final sin puntos de control intermedios.

### ¿Por qué priorizar el backend antes que el frontend?
Se decidió construir primero la capa de datos y lógica de negocio (modelo, repositorio, servicio, controlador) porque el frontend depende directamente de que existan endpoints funcionales que consumir. Desarrollar la interfaz antes hubiera significado trabajar con datos simulados que luego habría que reemplazar, duplicando esfuerzo.

### ¿Por qué dividir el trabajo de esta manera entre los dos integrantes?
La división por caso de uso (Edwin: filtros y ordenamiento; Gustavo: listado y búsqueda) permite que cada integrante domine y pueda defender con propiedad su propia porción del sistema, cumpliendo el requisito del enunciado de que cada estudiante comprometa un único caso de uso, sin perder la colaboración conjunta en configuración, diseño visual y pruebas.

### ¿Por qué Spring Boot + Angular?
Se eligió Spring Boot para el backend por ser la tecnología de mayor dominio del equipo (usada en cursos previos de bases de datos y desarrollo web), y por su integración natural con Spring Data JPA, que permite generar consultas de búsqueda, filtro y ordenamiento sin escribir SQL manual. Angular se eligió para el frontend por su arquitectura de componentes reutilizables (ideal para un componente de listado con múltiples controles) y por su integración nativa con TypeScript, que aporta tipado estático y mejor mantenibilidad frente a JavaScript plano.

### ¿Por qué H2 en memoria y no una base de datos persistente?
Dado que el proyecto debía completarse y entregarse en una sola sesión de 11 horas, usar H2 en memoria eliminó la necesidad de instalar, configurar y administrar un motor de base de datos externo (como MySQL o MariaDB), reduciendo así el riesgo de perder tiempo en configuración de infraestructura en lugar de en el desarrollo de las historias de usuario. Esta decisión es coherente con el principio de Scrum de priorizar la entrega de valor funcional sobre la complejidad técnica no esencial.

### Estadísticas de justificación (impacto de las funcionalidades)

Suponiendo un catálogo de 100 mascotas:

- La búsqueda por nombre reduce el tiempo de localización de aproximadamente 30 segundos (revisando manualmente) a 5 segundos (escribiendo el nombre), una reducción cercana al 83%.
- Filtrar por especie reduce el conjunto visible de 100 a un subconjunto mucho menor (por ejemplo, ~20 mascotas si hay 5 especies distribuidas uniformemente), disminuyendo en un 80% los elementos que el cliente debe revisar.
- Filtrar por rareza reduce aún más el conjunto (por ejemplo, a ~10 mascotas si hay 4 niveles de rareza), una reducción cercana al 90%.
- Ordenar por precio elimina la necesidad de revisar manualmente todo el catálogo para comparar opciones, facilitando decisiones de compra tanto para clientes con presupuesto limitado como para coleccionistas que buscan piezas exclusivas.

Estas mejoras están alineadas con principios de ingeniería de software centrados en la experiencia del usuario (usabilidad, eficiencia y reducción de carga cognitiva).

---

## 16. Tecnologías utilizadas

| Capa | Tecnología |
|---|---|
| Backend | Spring Boot 4.1.0, Java 21, Spring Data JPA, Maven |
| Base de datos | H2 (en memoria) |
| Frontend | Angular 22 (standalone components), TypeScript, HTML, CSS |
| Control de versiones | Git y GitHub ([https://github.com/MrWewin/PixelPets](https://github.com/MrWewin/PixelPets)) |
| Entorno de desarrollo | Visual Studio Code |

---

## 17. Conclusiones

El proyecto PixelPets demuestra la aplicación completa del marco de trabajo Scrum en un contexto de tiempo restringido (un único Sprint de 11 días/horas), cubriendo todos los artefactos y eventos exigidos: Product Goal, roles Scrum, Product Backlog, Sprint Planning, Sprint Backlog, Daily Scrum, Incremento, Sprint Review y Sprint Retrospective.

El producto final cumple con los seis requisitos funcionales planteados en el caso práctico (visualizar, buscar, filtrar por especie, filtrar por rareza, ordenar ascendente y ordenar descendente), implementados sobre una arquitectura real de dos capas (API REST en Spring Boot y cliente en Angular), con el código fuente completo publicado en un repositorio de GitHub accesible y verificable.

La experiencia reforzó la importancia de la comunicación y colaboración constante entre los integrantes del equipo para resolver bloqueos técnicos rápidamente, así como el valor de priorizar el desarrollo por capas (datos → lógica → API → interfaz) para mantener siempre un producto parcialmente funcional durante todo el proceso.
