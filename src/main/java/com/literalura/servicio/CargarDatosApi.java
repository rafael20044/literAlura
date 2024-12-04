package com.literalura.servicio;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;

public class CargarDatosApi {

    private final String API = "https://gutendex.com/books";
    
    
    public CargarDatosApi() {
    }
    
    public String buscarLibro(String titulo) throws IOException, InterruptedException{
        HttpClient client = HttpClient.newBuilder().followRedirects(HttpClient.Redirect.ALWAYS).build();
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(API+"?search="+titulo.toLowerCase()
                .replace(" ", "%20"))).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody =  response.body();
                // Parsear la respuesta JSON
        JSONObject jsonResponse = new JSONObject(responseBody);
        JSONArray results = jsonResponse.getJSONArray("results");

        if (results.length() > 0) {
            // Obtener el primer resultado
            JSONObject primerLibro = results.getJSONObject(0);
            return primerLibro.toString();
        } else {
            return "{}";
        }
    }
}
