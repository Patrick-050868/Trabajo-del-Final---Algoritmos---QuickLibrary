package utils;

import java.util.Scanner;

public class InputValidator {

    private InputValidator() {
    }

    public static String leerTexto(Scanner scanner, String mensaje) {
        String valor;
        do {
            System.out.print(mensaje);
            valor = scanner.nextLine().trim();
            if (valor.isEmpty()) {
                System.out.println("El campo no puede estar vacio.");
            }
        } while (valor.isEmpty());
        return valor;
    }

    public static int leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String valor = scanner.nextLine().trim();
            try {
                return Integer.parseInt(valor);
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido.");
            }
        }
    }
}
