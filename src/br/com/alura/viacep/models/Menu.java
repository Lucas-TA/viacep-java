package br.com.alura.viacep.models;

import java.util.Scanner;

public class Menu {
    public void showMenu() {
        System.out.println("Welcome to Search CEP");
        System.out.println("Please select one of the options below: ");
        System.out.println("""
                   1. Search CEP
                   2. Exit
                """);

        Scanner scanner = new Scanner(System.in);

        byte option = scanner.nextByte();

        ViaCepApi viaCepApi = new ViaCepApi();

        while (true) {
            if (option == 1) {
                System.out.println("Inform the CEP below: (Only numbers)");
                String cep = scanner.next();
                viaCepApi.searchCep(cep);
                showMenu();
            } else if (option == 2) {
                break;
            } else {
                System.out.println("Incorrect option. Try again.");
            }
        }
    }
}
