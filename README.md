# Taller 3 POO - Magos y Hechizos

---

**Valentina Castillo** -151666922 - Ingeniería en Tecnologías de la Información

**Pedro Segovia** - 21672694-4 - Ingeniería en Tecnologías de la Información

---

Proyecto desarrollado para el Taller 3 de Programacion Avanzada.

El sistema permite administrar magos y hechizos mediante archivos de texto, calcular puntuaciones segun el tipo de hechizo y generar reportes para un panel de analista.

## Importante sobre la entrega

En este repositorio se subio principalmente la carpeta con las clases fuente del proyecto, ya que GitHub no permite subir correctamente la carpeta `bin` generada por Eclipse.

La carpeta `bin` no es necesaria para revisar ni ejecutar el proyecto, porque Eclipse la genera automaticamente al compilar.

## Nombre del proyecto

Al crear o importar el proyecto en Eclipse, se recomienda usar el siguiente nombre:

```text
Taller3


## Estructura esperada

El proyecto debe quedar con una estructura similar a esta:

```text
Taller3
├── src
│   ├── factory
│   ├── main
│   ├── modelo
│   ├── persistencia
│   ├── servicio
│   ├── strategy
│   └── vista
├── data
│   ├── Hechizos.txt
│   └── Magos.txt
├── Diagrama_Clases.pdf
└── Modelo_Dominio.pdf
```

## Como ejecutar en Eclipse

1. Abrir Eclipse.
2. Crear un nuevo proyecto Java con el nombre `Taller3`.
3. Copiar la carpeta `src` dentro del proyecto.
4. Copiar la carpeta `data` en la raiz del proyecto, al mismo nivel que `src`.
5. Verificar que los archivos `Hechizos.txt` y `Magos.txt` esten dentro de `data`.
6. Abrir la clase:

```text
src/main/Main.java
```

7. Hacer clic derecho sobre `Main.java`.
8. Seleccionar:

```text
Run As -> Java Application
```

## Funcionalidades

El sistema cuenta con dos paneles principales:

## Administrador

Permite realizar operaciones CRUD:

- Agregar mago.
- Modificar mago.
- Eliminar mago.
- Agregar hechizo.
- Modificar hechizo.
- Eliminar hechizo.

Los cambios realizados se guardan en los archivos `.txt`.

## Analista

Permite consultar:

- Top 10 mejores hechizos.
- Top 3 mejores magos.
- Todos los hechizos.
- Todos los magos.
- Todos los hechizos junto a su puntuacion.
- Todos los magos junto a su puntuacion.

## Patrones de diseno utilizados

## Singleton

Utilizado en la clase `SistemaTaller`, para mantener una unica instancia del sistema durante la ejecucion.

## Factory

Utilizado en la clase `HechizoFactory`, para crear el tipo correcto de hechizo segun su elemento.

## Strategy

Utilizado mediante la interfaz `EstrategiaPuntuacion`, permitiendo calcular la puntuacion de cada hechizo segun su tipo.

## Modelo POO aplicado

El proyecto utiliza:

- Clases y objetos.
- Encapsulamiento.
- Herencia.
- Interfaces.
- Colecciones con `ArrayList`.
- Separacion entre modelo, vista, servicio y persistencia.

## Archivos de datos

El sistema utiliza los siguientes archivos:

```text
data/Hechizos.txt
data/Magos.txt
```

Estos archivos deben mantenerse en la raiz del proyecto dentro de la carpeta `data`, ya que el programa los carga y actualiza durante la ejecucion.

