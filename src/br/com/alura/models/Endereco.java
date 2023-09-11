package br.com.alura.models;

public record Endereco(String cep, String logradouro,
                       String complemento, String bairro,
                       String localidade, String uf) {
    @Override
    public String toString() {
        return "[CEP: " + cep + ", Rua: " + logradouro +
                ", Bairro: " + bairro +
                ", Cidade: " + localidade +
                ", UF: " + uf + "]";
    }
}
