package com.feederTool.webFeederTool;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FeederApplicationTests {


//	@Test
//	public void test_post_inbound_data() throws ExecutionException, InterruptedException, IOException {
//		String messageBody = ""; //
//		HttpClient httpClient = HttpClient.newHttpClient();
//		HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8887/feederTool/api/v3/processInput"))
//				.POST(HttpRequest.BodyPublishers.ofString(messageBody))
//				.build();
//
//	 CompletableFuture<HttpResponse<String>>  response = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
//
//		assertEquals(HttpStatus.ACCEPTED.value(), response.get().statusCode() );
//
//	}

}
