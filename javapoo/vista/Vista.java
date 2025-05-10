package vista;

import java.util.Scanner;

public class Vista {
    private static Scanner sc = new Scanner(System.in);

    public static int mostrarMenu() {
        System.out.println("--- MENÚ PRINCIPAL ---");
        System.out.println("1. Gestión clientes");
        System.out.println("2. Gestión proveedores");
        System.out.println("3. Gestión artículos");
        System.out.println("4. Gestión facturas");
        System.out.println("5. Gestión ventas");
        System.out.println("6. Información de ventas por cliente");
        System.out.println("0. Salir");
        System.out.print("Opción: ");
        return sc.nextInt();
    }
    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static void mostrarSeparador1() {
        System.out.println("---------------------------");
    }

    public static void mostrarSeparador() {
        System.out.println("---------------------------");
    }
}

