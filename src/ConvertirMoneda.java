import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConvertirMoneda {
    public Moneda convertirMoneda(String moneda) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/f1539955b3b7e9fc21c862b9/latest/" + moneda.toUpperCase());

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException |InterruptedException e) {
            throw new RuntimeException(e);
        }

        JsonObject jsonObject = new Gson().fromJson(response.body(), JsonObject.class);
        String baseCode = jsonObject.get("base_code").getAsString();
        double usd = jsonObject.get("conversion_rates").getAsJsonObject().get("USD").getAsDouble();
        double mxn = jsonObject.get("conversion_rates").getAsJsonObject().get("MXN").getAsDouble();
        double clp = jsonObject.get("conversion_rates").getAsJsonObject().get("CLP").getAsDouble();
        double ars = jsonObject.get("conversion_rates").getAsJsonObject().get("ARS").getAsDouble();
        return new Moneda(baseCode, usd, mxn, clp, ars);
    }
}
