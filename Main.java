import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Lyric Program Staring");
String artist = "radiohead";
String songname = "creep";

        HttpClient client = HttpClient.newBuilder().followRedirects(HttpClient.Redirect.NORMAL).
                build();

        HttpRequest request =HttpRequest.newBuilder()
                .uri(URI.create("https://api.lyrics.ovh/v1/"+artist+"/"+songname))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}