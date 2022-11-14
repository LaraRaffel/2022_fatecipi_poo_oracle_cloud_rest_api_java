import java.net.*;
import java.util.*;
import org.json.*;
import lombok.*;


@RequiredArgsConstructor// gerar construtor para inicializar variaveis
public class PessoaService {
    private static HttpClient client = HttpClient.newHttpClient();//cliente http, variavel de referencia
    private final String url;//constante
    public void listar(){
          public List<Pessoa> listar(){
            //Date e SimplesDateFormat
            //generics (desde a versão 5)
            List <Pessoa> pessoas = new ArrayList <> (); //diamante: versão 7
            try{
              HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
      
             var response = client.send(request, BodyHandlers.ofString()); // manipulador de corpo de resposta com o conteúdo de uma String
             //System.out.println(response.body());
                JSONObject raiz = new JSONObject(response.body()); //busca string
                JSONArray items = raiz.getJSONArray("items"); //da raiz obtém um jasonarray
                for (int i = 0; i < items.length(); i++){
                  JSONObject pessoaJSON = items.getJSONObject(i);
                  String nome = pessoaJSON.getString("nome");
                  int idade = pessoaJSON.getInt("idade");
                  String hobby = pessoaJSON.getString("hobby");
                  Pessoa p = new Pessoa();
                  p.setNome(nome);
                  p.setIdade(idade);
                  p.setHobby(hobby);
                  System.out.println(p);
                  System.out.println("******************");
                  pessoas.add(p);
                  }
              }
      
          catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            }
      
          return pessoas;
      
          }
      
      }
    }      
      
      //par chave valor apenas o objeto pode ter 