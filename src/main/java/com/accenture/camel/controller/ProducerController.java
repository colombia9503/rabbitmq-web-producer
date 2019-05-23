package com.accenture.camel.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.util.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.camel.model.MessageSource;
import com.accenture.camel.model.Operation;
import com.accenture.camel.model.Route;
import com.accenture.camel.service.ProducerService;
import com.accenture.proxy.error.service.ServiceException;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/")
public class ProducerController {
	
	private static final Logger log = LoggerFactory.getLogger(ProducerController.class);
	
	private ProducerService producerService;
	
	public ProducerController(ProducerService producerService) {
		this.producerService = producerService;
	}

	@PostMapping(path = "/produce")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public Mono<Void> sendMessage(@RequestBody MessageSource source, @RequestHeader("route") String route) {
		log.debug("Message received {}", source);
		return Mono.create(emitter -> {
			log.debug("Route: {}", route);
			
			emitter.success();
		});
	}
	
	@GetMapping(path = {"/routes"}, produces = {"application/json", "application/xml"})
	@ResponseStatus(value = HttpStatus.OK)
	public Mono<List<Route>> getRoutesList() {
		return Mono.just(new ArrayList<>());
	}
	
	@PostMapping("/publish")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public Mono<Void> publishMessage(@RequestBody MessageSource source) {
		return Mono.create(emitter -> {
			emitter.success();
		});
	}
	
	@PostMapping("/add")
	public Mono<JsonObject> add(@RequestBody Operation operation) {
		return Mono.just(operation).flatMap(op -> {
			try {
				return Mono.just(producerService.add(op));
			} catch (ServiceException e) {
				return Mono.error(e);
			}
		});
	}
	
	@PostMapping("/extract")
	public Mono<JsonObject> extract(@RequestBody Operation operation) {
		return Mono.just(operation).flatMap(op -> {
			try {
				return Mono.just(producerService.extract(op));
			} catch (ServiceException e) {
				return Mono.error(e);
			}
		});
	}
	
	@PostMapping("/divide")
	public Mono<JsonObject> divide(@RequestBody Operation operation) {
		return Mono.just(operation).flatMap(op -> {
			try {
				return Mono.just(producerService.divide(op));
			} catch (ServiceException e) {
				return Mono.error(e);
			}
		});
	}
	
	@PostMapping("/multiply")
	public Mono<JsonObject> multiply(@RequestBody Operation operation) {
		return Mono.just(operation).flatMap(op -> {
			try {
				return Mono.just(producerService.multiply(op));
			} catch (ServiceException e) {
				return Mono.error(e);
			}
		});
	}
}
