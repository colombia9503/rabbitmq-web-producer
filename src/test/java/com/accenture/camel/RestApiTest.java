package com.accenture.camel;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import com.accenture.camel.model.MessageSource;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
@RunWith(SpringRunner.class)
@WebFluxTest
@ActiveProfiles(value = {"dev"})
public class RestApiTest {
	@Autowired
	private WebTestClient webClient;
	
	private Gson gson;
	
	@Before
	public void init() {
		gson = new GsonBuilder().create();
	}
	

	@Test
	public void postProduceMessageSuccessfulTest() {
		webClient.post().uri("/api/v1/produce")
		.contentType(MediaType.APPLICATION_JSON)
		.header("route", "foo")
		.body(BodyInserters.fromObject(gson.toJson(new MessageSource("foo").addPayload("message", "Hello world"))))
		.exchange()
		.expectStatus().isAccepted();
	}
	
	@Test
	public void getRoutesListSuccessfulTest() {
		webClient.get().uri("/api/v1/routes")
		.accept(MediaType.APPLICATION_JSON)
		.exchange()
		.expectStatus().isOk();
	}
	
	@Test
	public void postPublishMessageSuccessfulTest() {
		webClient.post().uri("/api/v1/publish")
		.accept(MediaType.APPLICATION_JSON)
		.body(BodyInserters.fromObject(new MessageSource("foo").addPayload("message", "Hello world!!")))
		.exchange()
		.expectStatus().isAccepted();
		
	}
}