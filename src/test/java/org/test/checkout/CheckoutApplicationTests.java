package org.test.checkout;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.test.checkout.model.Item;

import java.net.URI;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource(properties = "server.port=9080")
class CheckoutApplicationTests {

	@LocalServerPort
	int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {

	}

	@Test
	public void getItems() throws Exception {

		final String baseUrl = "http://localhost:"+port+"/item/";
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		ResponseEntity<String> response = testRestTemplate.
				getForEntity(baseUrl, String.class);
		RestTemplate restTemplate = new RestTemplate();
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals("[{\"rfid\":\"44c67bf9-a247-4bb6-bfb4-8c6f09b71286\",\"code\":\"VOUCHER\",\"name\":\"Gift Card\",\"price\":5},{\"rfid\":\"e4ce84c7-609d-4a61-844e-e9e3428a85ed\",\"code\":\"TSHIRT\",\"name\":\"Summer T-Shirt\",\"price\":20},{\"rfid\":\"8aef2a78-dc31-4d27-96b6-e3ba8b9c8813\",\"code\":\"PANTS\",\"name\":\"Summer Pants\",\"price\":7.5}]", response.getBody());

	}

	@Test
	public void addItemToCart() throws Exception {

		final String baseUrl = "http://localhost:"+port+"/checkout/items/";
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		ResponseEntity<String> response = testRestTemplate.postForEntity(baseUrl,"44c67bf9-a247-4bb6-bfb4-8c6f09b71286", String.class);
		assertEquals( HttpStatus.OK,response.getStatusCode());
	}

	@Test
	public void getPreviewOrder() throws Exception {

		final String baseUrl = "http://localhost:"+port;
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		//
		ResponseEntity<String> responseItem = testRestTemplate.postForEntity(baseUrl + "/checkout/items/","44c67bf9-a247-4bb6-bfb4-8c6f09b71286", String.class);
		assertEquals( HttpStatus.OK,responseItem.getStatusCode());

		responseItem = testRestTemplate.postForEntity(baseUrl + "/checkout/items/","44c67bf9-a247-4bb6-bfb4-8c6f09b71286", String.class);
		assertEquals( HttpStatus.OK,responseItem.getStatusCode());

		ResponseEntity<String> responseCart = testRestTemplate.getForEntity(baseUrl+"/checkout/items/", String.class);
		assertEquals( HttpStatus.OK,responseCart.getStatusCode());
		System.out.println(responseCart.getBody());

		ResponseEntity<String> responsePreviewOrder = testRestTemplate.getForEntity(baseUrl+"/checkout/previeworder/", String.class);
		assertEquals( HttpStatus.OK,responsePreviewOrder.getStatusCode());
		System.out.println(responsePreviewOrder.getBody());

		assertEquals( HttpStatus.OK,responsePreviewOrder.getStatusCode());
		assertEquals("{\"total\":10,\"totalWithDiscount\":5.0}",responsePreviewOrder.getBody());

	}
}
