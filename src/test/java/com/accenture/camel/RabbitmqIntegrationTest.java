package com.accenture.camel;

import org.apache.camel.CamelContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqIntegrationTest {
	@Autowired
	private CamelContext camelContext;
	
	@Test
	public void apacheCamelContextTest() {
		
	}
}
