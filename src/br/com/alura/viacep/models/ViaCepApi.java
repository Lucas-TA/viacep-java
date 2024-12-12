package br.com.alura.viacep.models;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ViaCepApi {

    public AddressViaCep searchCep(String cep) {
        URI uri = URI.create("https://viacep.com.br/ws/" + cep + "/json/");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();
        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), AddressViaCep.class);
        } catch (Exception e) {
            throw new RuntimeException("It was not possible to obtain the address searched");
        }

    }
}
