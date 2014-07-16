package test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class Client {
	
	public static String grabContent(String link) throws ParseException, IOException, URISyntaxException{
		String url = "http://speedportal.sinaapp.com/grabContent";
        CloseableHttpClient httpClient = HttpClients.createDefault();            
		HttpUriRequest grabContent = RequestBuilder.
				post().
				setUri(new URI(url)).
				addParameter("graburl", link).
				build();
        CloseableHttpResponse grabresponse = httpClient.execute(grabContent);
        String retSrc = EntityUtils.toString(grabresponse.getEntity());
        return retSrc;
	}

	public static void main(String[] args) throws ClientProtocolException, IOException, URISyntaxException {
		// TODO Auto-generated method stub("http://www.news.163.com");
		String graburl = "http://news.163.com/14/0703/11/A07P8UT900014JB6.html";
		System.out.println(grabContent(graburl));
	}

}
