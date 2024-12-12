package br.com.alura.viacep.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class JsonGenerator {
    public void generate(AddressViaCep addressViaCep) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        FileWriter fw = new FileWriter("cep.json");
        fw.write(gson.toJson(addressViaCep));
        fw.close();
    }
}
