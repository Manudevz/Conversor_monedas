package com.alura.conversorMonedas;

import java.io.IOException;
import java.net.http.HttpClient;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        boolean flag = true;
        Scanner teclado = new Scanner(System.in);
        HttpClient client = HttpClient.newHttpClient();
        ConversorMoneda conversor = new ConversorMoneda();

        while (flag) {
            System.out.println("********************************************");
            System.out.println("Sea bienvenido al conversor de monedas.");
            System.out.println("1) Dólar ==> Peso Argentino.");
            System.out.println("2) Peso Argentino ==> Dólar.");
            System.out.println("3) Dólar ==> Real Brasileño.");
            System.out.println("4) Real Brasileño ==> Dólar.");
            System.out.println("5) Dólar ==> Peso Colombiano.");
            System.out.println("6) Peso Colombiano ==> Dólar.");
            System.out.println("7) Salir.");
            System.out.println("Elija una opción válida: ");
            System.out.println("********************************************");
            int opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    // Dólar a Peso Argentino
                    conversor.convertirMoneda(client, "USD", "ARS");
                    break;
                case 2:
                    // Peso Argentino a Dólar
                    conversor.convertirMoneda(client, "ARS", "USD");
                    break;
                case 3:
                    // Dólar a Real Brasileño
                    conversor.convertirMoneda(client, "USD", "BRL");
                    break;
                case 4:
                    // Real Brasileño a Dólar
                    conversor.convertirMoneda(client, "BRL", "USD");
                    break;
                case 5:
                    // Dólar a Peso Colombiano
                    conversor.convertirMoneda(client, "USD", "COP");
                    break;
                case 6:
                    // Peso Colombiano a Dólar
                    conversor.convertirMoneda(client, "COP", "USD");
                    break;
                case 7:
                    // Salir
                    flag = false;
                    System.out.println("Gracias por usar el conversor de monedas. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }

        teclado.close();
    }
}
