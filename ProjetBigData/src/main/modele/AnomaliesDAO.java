import okhttp3.*;

import javax.swing.text.Document;
import java.io.IOException;
import java.util.List;

public class AnomaliesDAO {
    private static final String BASE_URL = "https://eu-central-1.aws.data.mongodb-api.com/app/data-owjzf/endpoint/data/v1";
    private static final String API_KEY = "LgTljCghQxMqcBGLZzrKF46I7iGhVYM66DNNrJpLxTzEDQHsfyzHVHOFn8iWjaNO";

    public List<Document> getAllAnomalies() {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");

        RequestBody body = RequestBody.create("", mediaType);
        Request request = new Request.Builder()
                .url(BASE_URL + "/document_entier/anomalies_paris/find")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("api-key", API_KEY)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                System.out.println(responseBody);
            } else {
                System.out.println("Erreur : " + response.code() + " " + response.message());
            }
        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        return null;
    }
}

/*
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class AnomaliesDAO {

    private final String cleAPI = "LgTljCghQxMqcBGLZzrKF46I7iGhVYM66DNNrJpLxTzEDQHsfyzHVHOFn8iWjaNO";

    public JSONObject getAnomalies() throws Exception {

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost("https://eu-central-1.aws.data.mongodb-api.com/app/data-owjzf/endpoint/data/v1/action/find");

        // Ajout des headers
        request.addHeader("Content-Type", "application/json");
        request.addHeader("api-key", cleAPI);

        // Ajout du body (la requête)
        JSONObject requestBody = new JSONObject();
        requestBody.put("database", "document_entier");
        requestBody.put("collection", "anomalies_paris");
        requestBody.put("dataSource", "Cluster0");
        requestBody.put("filter", new JSONObject());

        StringEntity entity = new StringEntity(requestBody.toString());
        request.setEntity(entity);

        // Envoi de la requête et récupération de la réponse
        HttpResponse response = httpClient.execute(request);

        // Vérification du code de réponse HTTP
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != 200) {
            throw new Exception("Erreur lors de la requête : code " + statusCode);
        }

        // Récupération des données JSON de la réponse
        String jsonResponse = EntityUtils.toString(response.getEntity());
        return new JSONObject(jsonResponse);
    }
}
*/