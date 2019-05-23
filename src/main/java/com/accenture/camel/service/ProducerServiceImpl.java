package com.accenture.camel.service;

import org.apache.camel.util.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.camel.model.Operation;
import com.accenture.proxy.error.service.ServiceException;
import com.accenture.proxy.integration.MessagingPlatformType;
import com.accenture.proxy.integration.ProducerComponent;

@Service
public class ProducerServiceImpl implements ProducerService {

	@Autowired
	private ProducerComponent producerComponent;

	@Override
	public JsonObject add(Operation operation) throws ServiceException {
		JsonObject object = new JsonObject();
		object.put("a", operation.getA());
		object.put("b", operation.getB());
		JsonObject response = producerComponent.sendMessage(object, "operationsService", "add",
				MessagingPlatformType.RABBITMQ);

		return response;
	}

	@Override
	public JsonObject extract(Operation operation) throws ServiceException {
		JsonObject object = new JsonObject();
		object.put("a", operation.getA());
		object.put("b", operation.getB());
		JsonObject response = producerComponent.sendMessage(object, "operationsService", "extract",
				MessagingPlatformType.RABBITMQ);

		return response;
	}

	@Override
	public JsonObject divide(Operation operation) throws ServiceException {
		JsonObject object = new JsonObject();
		object.put("a", operation.getA());
		object.put("b", operation.getB());
		JsonObject response = producerComponent.sendMessage(object, "operationsService", "divide",
				MessagingPlatformType.RABBITMQ);

		return response;
	}

	@Override
	public JsonObject multiply(Operation operation) throws ServiceException {
		JsonObject object = new JsonObject();
		object.put("a", operation.getA());
		object.put("b", operation.getB());
		JsonObject response = producerComponent.sendMessage(object, "operationsService", "multiply",
				MessagingPlatformType.RABBITMQ);

		return response;
	}
}
