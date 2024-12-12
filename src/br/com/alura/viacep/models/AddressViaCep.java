package br.com.alura.viacep.models;

public record AddressViaCep(String cep, String logradouro, String complemento, String bairro, String localidade, String uf) {}
