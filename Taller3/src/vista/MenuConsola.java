package vista;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.Hechizo;
import modelo.Mago;
import servicio.SistemaTaller;

public class MenuConsola {

    private Scanner scanner;
    private SistemaTaller sistema;

    public MenuConsola() {
        this.scanner = new Scanner(System.in);
        this.sistema = SistemaTaller.getInstancia();
    }

    public void iniciar() {
        try {
            sistema.cargarDatos();
            ejecutarMenuPrincipal();
        } catch (Exception exception) {
            System.out.println("Error al iniciar el sistema: " + exception.getMessage());
        }
    }

    private void ejecutarMenuPrincipal() throws IOException {
        int opcion;
        do {
            System.out.println("===== SISTEMA DE MAGOS Y HECHIZOS =====");
            System.out.println("1. Administrador");
            System.out.println("2. Analista");
            System.out.println("0. Salir");
            opcion = leerEntero("Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    ejecutarMenuAdministrador();
                    break;
                case 2:
                    ejecutarMenuAnalista();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
            System.out.println();
        } while (opcion != 0);
    }

    private void ejecutarMenuAdministrador() throws IOException {
        int opcion;
        do {
            System.out.println("===== ADMINISTRADOR =====");
            System.out.println("1. Agregar Mago");
            System.out.println("2. Modificar Mago");
            System.out.println("3. Eliminar Mago");
            System.out.println("4. Agregar Hechizo");
            System.out.println("5. Modificar Hechizo");
            System.out.println("6. Eliminar Hechizo");
            System.out.println("0. Volver");
            opcion = leerEntero("Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    agregarMago();
                    break;
                case 2:
                    modificarMago();
                    break;
                case 3:
                    eliminarMago();
                    break;
                case 4:
                    agregarHechizo();
                    break;
                case 5:
                    modificarHechizo();
                    break;
                case 6:
                    eliminarHechizo();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
            System.out.println();
        } while (opcion != 0);
    }

    private void ejecutarMenuAnalista() {
        int opcion;
        do {
            System.out.println("===== ANALISTA =====");
            System.out.println("1. Top 10 Mejores Hechizos");
            System.out.println("2. Top 3 Mejores Magos");
            System.out.println("3. Mostrar todos los Hechizos");
            System.out.println("4. Mostrar todos los magos");
            System.out.println("5. Mostrar todos los Hechizos junto a su puntuacion");
            System.out.println("6. Mostrar todos los magos junto a su puntuacion");
            System.out.println("0. Volver");
            opcion = leerEntero("Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    mostrarTopHechizos();
                    break;
                case 2:
                    mostrarTopMagos();
                    break;
                case 3:
                    mostrarHechizos(false);
                    break;
                case 4:
                    mostrarMagos(false);
                    break;
                case 5:
                    mostrarHechizos(true);
                    break;
                case 6:
                    mostrarMagos(true);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
            System.out.println();
        } while (opcion != 0);
    }

    private void agregarMago() throws IOException {
        String nombre = leerTexto("Nombre del mago: ");
        List<String> nombresHechizos = leerListaHechizos();
        if (sistema.agregarMago(nombre, nombresHechizos)) {
            System.out.println("Mago agregado correctamente.");
        } else {
            System.out.println("Ya existe un mago con ese nombre.");
        }
    }

    private void modificarMago() throws IOException {
        String nombreActual = leerTexto("Nombre del mago a modificar: ");
        if (sistema.buscarMago(nombreActual) == null) {
            System.out.println("No existe un mago con ese nombre.");
            return;
        }
        String nuevoNombre = leerTexto("Nuevo nombre del mago: ");
        List<String> nuevosHechizos = leerListaHechizos();
        sistema.modificarMago(nombreActual, nuevoNombre, nuevosHechizos);
        System.out.println("Mago modificado correctamente.");
    }

    private void eliminarMago() throws IOException {
        String nombre = leerTexto("Nombre del mago a eliminar: ");
        if (sistema.eliminarMago(nombre)) {
            System.out.println("Mago eliminado correctamente.");
        } else {
            System.out.println("No existe un mago con ese nombre.");
        }
    }

    private void agregarHechizo() throws IOException {
        DatosHechizo datos = leerDatosHechizo("Nombre del hechizo: ");
        if (sistema.agregarHechizo(datos.nombre, datos.tipo, datos.dano, datos.primerParametro, datos.segundoParametro)) {
            System.out.println("Hechizo agregado correctamente.");
        } else {
            System.out.println("Ya existe un hechizo con ese nombre.");
        }
    }

    private void modificarHechizo() throws IOException {
        String nombreActual = leerTexto("Nombre del hechizo a modificar: ");
        if (sistema.buscarHechizo(nombreActual) == null) {
            System.out.println("No existe un hechizo con ese nombre.");
            return;
        }
        DatosHechizo datos = leerDatosHechizo("Nuevo nombre del hechizo: ");
        sistema.modificarHechizo(nombreActual, datos.nombre, datos.tipo, datos.dano, datos.primerParametro,
                datos.segundoParametro);
        System.out.println("Hechizo modificado correctamente.");
    }

    private void eliminarHechizo() throws IOException {
        String nombre = leerTexto("Nombre del hechizo a eliminar: ");
        if (sistema.eliminarHechizo(nombre)) {
            System.out.println("Hechizo eliminado correctamente.");
        } else {
            System.out.println("No existe un hechizo con ese nombre.");
        }
    }

    // ArrayList se usa para guardar los hechizos ingresados por el usuario antes de asignarlos al mago.
    private List<String> leerListaHechizos() {
        List<String> nombresHechizos = new ArrayList<String>();
        int cantidad = leerEntero("Cantidad de hechizos que domina: ");
        while (cantidad <= 0) {
            System.out.println("La cantidad debe ser mayor a cero.");
            cantidad = leerEntero("Cantidad de hechizos que domina: ");
        }
        for (int i = 0; i < cantidad; i++) {
            String nombreHechizo = leerTexto("Nombre del hechizo " + (i + 1) + ": ");
            if (sistema.existeHechizo(nombreHechizo)) {
                nombresHechizos.add(nombreHechizo);
            } else {
                System.out.println("El hechizo no existe en el catalogo. Ingrese otro.");
                i--;
            }
        }
        return nombresHechizos;
    }

    private DatosHechizo leerDatosHechizo(String mensajeNombre) {
        String nombre = leerTexto(mensajeNombre);
        String tipo = leerTipoHechizo();
        int dano = leerEntero("Dano del hechizo: ");
        int primerParametro;
        int segundoParametro = 0;

        if ("Fuego".equalsIgnoreCase(tipo)) {
            primerParametro = leerEntero("Duracion quemadura: ");
        } else if ("Tierra".equalsIgnoreCase(tipo)) {
            primerParametro = leerEntero("Mejora defensa: ");
        } else if ("Planta".equalsIgnoreCase(tipo)) {
            primerParametro = leerEntero("Duracion stun: ");
            segundoParametro = leerEntero("Cantidad plantas: ");
        } else {
            primerParametro = leerEntero("Cantidad heal: ");
            segundoParametro = leerEntero("Presion del agua: ");
        }
        return new DatosHechizo(nombre, tipo, dano, primerParametro, segundoParametro);
    }

    private String leerTipoHechizo() {
        String tipo;
        do {
            tipo = leerTexto("Tipo (Fuego/Tierra/Planta/Agua): ");
            if (esTipoValido(tipo)) {
                return normalizarTipo(tipo);
            }
            System.out.println("Tipo no valido.");
        } while (true);
    }

    private boolean esTipoValido(String tipo) {
        return "Fuego".equalsIgnoreCase(tipo) || "Tierra".equalsIgnoreCase(tipo) || "Planta".equalsIgnoreCase(tipo)
                || "Agua".equalsIgnoreCase(tipo);
    }

    private String normalizarTipo(String tipo) {
        String limpio = tipo.trim().toLowerCase();
        return limpio.substring(0, 1).toUpperCase() + limpio.substring(1);
    }

    private void mostrarTopHechizos() {
        System.out.println("===== TOP 10 MEJORES HECHIZOS =====");
        int posicion = 1;
        for (Hechizo hechizo : sistema.obtenerTopHechizos(10)) {
            System.out.println(posicion + ". " + formatearHechizo(hechizo, true));
            posicion++;
        }
    }

    private void mostrarTopMagos() {
        System.out.println("===== TOP 3 MEJORES MAGOS =====");
        int posicion = 1;
        for (Mago mago : sistema.obtenerTopMagos(3)) {
            System.out.println(posicion + ". " + formatearMago(mago, true));
            posicion++;
        }
    }

    private void mostrarHechizos(boolean conPuntuacion) {
        System.out.println("===== HECHIZOS =====");
        for (Hechizo hechizo : sistema.getHechizos()) {
            System.out.println(formatearHechizo(hechizo, conPuntuacion));
        }
    }

    private void mostrarMagos(boolean conPuntuacion) {
        System.out.println("===== MAGOS =====");
        for (Mago mago : sistema.getMagos()) {
            System.out.println(formatearMago(mago, conPuntuacion));
        }
    }

    private String formatearHechizo(Hechizo hechizo, boolean conPuntuacion) {
        String texto = hechizo.getNombre() + " | Tipo: " + hechizo.getTipo() + " | Dano: " + hechizo.getDano()
                + " | " + hechizo.obtenerDescripcionParametros();
        if (conPuntuacion) {
            texto += " | Puntuacion: " + String.format("%.2f", hechizo.calcularPuntuacion());
        }
        return texto;
    }

    private String formatearMago(Mago mago, boolean conPuntuacion) {
        String texto = mago.getNombre() + " | Hechizos: " + String.join(", ", mago.getNombresHechizos());
        if (conPuntuacion) {
            texto += " | Puntuacion: " + String.format("%.2f", mago.calcularPuntuacion(sistema.getHechizos()));
        }
        return texto;
    }

    private int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException exception) {
                System.out.println("Debe ingresar un numero entero.");
            }
        }
    }

    private String leerTexto(String mensaje) {
        String texto;
        do {
            System.out.print(mensaje);
            texto = scanner.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("El texto no puede estar vacio.");
            }
        } while (texto.isEmpty());
        return texto;
    }

    private static class DatosHechizo {
        private String nombre;
        private String tipo;
        private int dano;
        private int primerParametro;
        private int segundoParametro;

        public DatosHechizo(String nombre, String tipo, int dano, int primerParametro, int segundoParametro) {
            this.nombre = nombre;
            this.tipo = tipo;
            this.dano = dano;
            this.primerParametro = primerParametro;
            this.segundoParametro = segundoParametro;
        }
    }
}

