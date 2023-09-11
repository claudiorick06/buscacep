package br.com.alura.models;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.lang.reflect.Type;

public class ConsultaCEP {
    public Endereco buscaEndereco(int cep) {
        URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();
        HttpResponse<String> response;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não consegui obter o endereço a partir desse CEP!");
        }
        return new Gson().fromJson(response.body(), Endereco.class);
    }

    public List<Endereco> buscaCEP(String uf, String cidade, String logradouro) {
        String cidadesemespaco = cidade.replace(" ", "%20");
        String logradourosemespaco = logradouro.replace(" ", "+");
        URI endereco = URI.create(String.format("https://viacep.com.br/ws/%s/%s/%s/json/", uf, cidadesemespaco, logradourosemespaco));

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();
        HttpResponse<String> response;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new RuntimeException("Não consegui obter o endereço a partir desses critérios!");
        }

        // Use o TypeToken para desserializar a lista de endereços
        Type tipoListaEndereco = new TypeToken<List<Endereco>>() {}.getType();
        return new Gson().fromJson(response.body(), tipoListaEndereco);
    }
}
