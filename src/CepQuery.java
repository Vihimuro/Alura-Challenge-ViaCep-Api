import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CepQuery {
    public Adress searchAdress(String cep){
        String urlRequest = "https://viacep.com.br/ws/" + cep + "/json/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlRequest))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String jsonResponse = response.body();
            return new Gson().fromJson(jsonResponse, Adress.class);
        } catch (Exception e) {
            throw new RuntimeException("Cannot find data with the cep given.");
        }
    }
}
