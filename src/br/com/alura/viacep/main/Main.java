package br.com.alura.viacep.main;

import br.com.alura.viacep.models.AddressViaCep;
import br.com.alura.viacep.models.JsonGenerator;
import br.com.alura.viacep.models.ViaCepApi;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ViaCepApi api = new ViaCepApi();

        System.out.println("Inform the CEP below: ");
        String cep = sc.nextLine();

        try {
            AddressViaCep address = api.searchCep(cep);
            System.out.println(address);
            JsonGenerator generator = new JsonGenerator();
            generator.generate(address);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Closing the application");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}