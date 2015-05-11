import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Skurishin Vladislav
 * @since 11.05.15
 */
public class VKTest
{
    public static void main(String[] args) throws IOException, URISyntaxException
    {
        getUser();

        java.net.URI uri = new URIBuilder()
                .setScheme("https")
                .setHost("api.vk.com/method")
                .setPath("/users.search")
                .setParameter("count", "5")
                .setParameter("fields","photo,screen_name")
                .setParameter("sex", "1")
                .setParameter("university", "60")
                .setParameter("v", "5.31")
                .build();


        HttpClient client = HttpClientBuilder
                .create()
                .build();

        System.out.println(uri);

        HttpGet request = new HttpGet(uri);

        HttpResponse response = client.execute(request);

        System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        System.out.println(result);
    }

    private static void getUser() throws URISyntaxException, IOException
    {
        URI uri = new URIBuilder()
                .setScheme("https")
                .setHost("api.vk.com/method")
                .setPath("/users.get")
                .setParameter("user_ids", "66748")
                .setParameter("v", "5.31")
                .build();


        HttpClient client = HttpClientBuilder
                .create()
                .build();

        System.out.println(uri);

        HttpGet request = new HttpGet(uri);

        HttpResponse response = client.execute(request);

        System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        System.out.println(result);
    }
}
