# Taller 3 POO - Magos y Hechizos

## Integrantes

- Valentina Castillo - 15166692-2 - Ingenieria en Tecnologias de la Informacion
- Pedro Segovia - 21672694-4 - Ingenieria en Tecnologias de la Informacion

## Descripcion del proyecto

Este proyecto corresponde al Taller 3 de Programacion Orientada a Objetos.

El sistema permite administrar magos y hechizos mediante archivos de texto. Cada mago posee uno o mas hechizos, y cada hechizo pertenece a un tipo elemental: Fuego, Tierra, Planta o Agua.

El programa permite calcular puntuaciones de hechizos segun su tipo y calcular la puntuacion total de cada mago sumando los puntajes de los hechizos que domina.

## Importante sobre la entrega

En este repositorio se suben las clases fuente del proyecto y los archivos necesarios para su ejecucion.


## Nombre recomendado del proyecto

Al crear el proyecto en Eclipse, se recomienda usar el siguiente nombre:

Taller3


## Estructura del proyecto

La estructura esperada del proyecto es la siguiente:

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

## Paquetes principales

- `main`: contiene la clase principal que inicia el programa.
- `vista`: contiene el menu de consola y la interaccion con el usuario.
- `servicio`: contiene la logica principal del sistema.
- `modelo`: contiene las clases del dominio, como magos y hechizos.
- `persistencia`: contiene la lectura y escritura de archivos `.txt`.
- `factory`: contiene la fabrica encargada de crear hechizos segun su tipo.
- `strategy`: contiene las estrategias de calculo de puntuacion.

## Como ejecutar en Eclipse

1. Abrir Eclipse.
2. Crear un nuevo proyecto Java llamado `Taller3`.
3. Copiar la carpeta `src` dentro del proyecto.
4. Copiar la carpeta `data` en la raiz del proyecto, al mismo nivel que `src`.
5. Verificar que existan los archivos:

```text
data/Hechizos.txt
data/Magos.txt
```

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

El sistema cuenta con dos paneles principales: Administrador y Analista.

## Panel Administrador

Permite realizar las siguientes operaciones:

- Agregar mago.
- Modificar mago.
- Eliminar mago.
- Agregar hechizo.
- Modificar hechizo.
- Eliminar hechizo.

Los cambios realizados se reflejan en los archivos `.txt`.

## Panel Analista

Permite consultar:

- Top 10 mejores hechizos.
- Top 3 mejores magos.
- Todos los hechizos.
- Todos los magos.
- Todos los hechizos junto a su puntuacion.
- Todos los magos junto a su puntuacion.

## Calculo de puntuaciones

Cada tipo de hechizo calcula su puntuacion de manera distinta:

- Fuego: `dano * duracionQuemadura`
- Tierra: `(dano * mejoraDefensa) / 2`
- Planta: `dano + (duracionStun * cantidadPlantas)`
- Agua: `(dano + cantidadHeal + presionAgua) * 2`

La puntuacion de un mago se calcula sumando las puntuaciones de todos los hechizos que domina.

## Patrones de diseno utilizados

## Singleton

Se utiliza en la clase `SistemaTaller`.

Permite mantener una unica instancia del sistema durante toda la ejecucion.

## Factory

Se utiliza en la clase `HechizoFactory`.

Permite crear el tipo correcto de hechizo segun el elemento ingresado o leido desde archivo.

## Strategy

Se utiliza mediante la interfaz `EstrategiaPuntuacion`.

Permite separar el calculo de puntuacion de cada tipo de hechizo en clases independientes.

## Modelo POO aplicado

El proyecto utiliza:

- Clases y objetos.
- Encapsulamiento.
- Herencia.
- Interfaces.
- Clase abstracta.
- Colecciones con `ArrayList`.
- Separacion entre entrada, logica, modelo y persistencia.

## Archivos de datos

El sistema utiliza dos archivos principales:

```text
data/Hechizos.txt
data/Magos.txt
```

Estos archivos deben mantenerse dentro de la carpeta `data`, ubicada en la raiz del proyecto.

## Diagramas

El proyecto incluye:

- `Diagrama_Clases.pdf`
- `Modelo_Dominio.pdf`
