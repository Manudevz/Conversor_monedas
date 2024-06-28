package com.alura.conversorMonedas;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConversorMoneda {

    private final Gson gson = new Gson();
    private final Scanner scanner = new Scanner(System.in);

    public void convertirMoneda(HttpClient client, String moneda1, String moneda2) {
        // Solicitar al usuario el valor a convertir
        System.out.print("Ingresa el valor que deseas convertir: ");
        double valor = scanner.nextDouble();

        String url = String.
                format("https://v6.exchangerate-api.com/v6/776f6fe089837c40d5fabb9d/pair/%s/%s", moneda1, moneda2);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();

            // Parsear el JSON usando Gson
            JsonObject jsonObject = gson.fromJson(responseBody, JsonObject.class);
            double conversionRate = jsonObject.get("conversion_rate").getAsDouble();

            // Calcular el monto convertido
            double montoConvertido = valor * conversionRate;

            // Mostrar el resultado
            String mensajeResultado = String
                    .format("El valor de %.2f [%s] equivale a %.2f [%s]", valor, moneda1, montoConvertido, moneda2);
            System.out.println(mensajeResultado);
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al obtener la tasa de cambio: " + e.getMessage());
        }
    }
}
