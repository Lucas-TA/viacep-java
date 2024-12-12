package br.com.alura.viacep.models;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ViaCepApi {

    public void searchCep(String cep) {
        String address = "https://viacep.com.br/ws/" + cep + "/json/";
        List<Address> ceps = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(address))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            Address addresses = gson.fromJson(json, Address.class);
            System.out.println(addresses);

            System.out.println(json);

//            ceps.add(json);

            FileWriter writer = new FileWriter("cep.json");
            writer.write(gson.toJson(addresses));
            writer.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }
}
