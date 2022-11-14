import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import org.json.JSONArray;
import org.json.JSONObject;
import lombok.RequiredArgsConstructor;
import java.net.URI;

@RequiredArgsConstructor// gerar construtor para inicializar variaveis
public class PessoaService {
    private static HttpClient client = HttpClient.newHttpClient();//cliente http, variavel de referencia
    private final String url;//constante
    public void listar(){
        try{
            //design pattern: builder
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();// manipulador de corpo de resposta com o conteúdo de uma String
            var response = client.send(request, BodyHandlers.ofString());
            System.out.println(response.body());
            JSONObject raiz = new JSONObject(response.body());
            JSONArray items = raiz.getJSONArray("items");
            JSONObject primeiro = items.getJSONObject(0);
            //System.out.println(primeiro);
            String nome = primeiro.getString("nome");
            System.out.println(nome);
        }

        catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}