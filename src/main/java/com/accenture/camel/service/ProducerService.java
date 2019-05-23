package com.accenture.camel.service;

import org.apache.camel.util.json.JsonObject;

import com.accenture.camel.model.Operation;
import com.accenture.proxy.error.service.ServiceException;

public interface ProducerService {
	public JsonObject add(Operation operation) throws ServiceException;
	public JsonObject extract(Operation operation) throws ServiceException;
	public JsonObject divide(Operation operation) throws ServiceException;
	public JsonObject multiply(Operation operation) throws ServiceException;
}
