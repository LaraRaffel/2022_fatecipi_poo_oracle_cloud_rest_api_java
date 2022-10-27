import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.logging.FileHandler;
import lombok.RequiredArgsConstructor;
import lombok.var;

@RequiredArgsConstructor// gerar construtor para inicializar variaveis
public class PessoaService {
    
    private  HttpClient client = HttpClient.newHttpClient(); //cliente http, variavel de referencia
    private final String url ;//constante

   
    public void listar(){
      try{
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

       var response = client.send(request, BodyHandlers.ofString()); // manipulador de corpo de resposta com o conteúdo de uma Striong
        System.out.println(response.body());
    }  
      catch(Exception e){
        System.out.println(e.getMessage());
        e.printStackTrace();
      }
    }
   
}
