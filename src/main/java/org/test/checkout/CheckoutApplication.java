package org.test.checkout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.test.checkout.model.Item;
import org.test.checkout.model.Rules;
import org.test.checkout.model.TypeEnum;
import org.test.checkout.repository.CartRepository;
import org.test.checkout.repository.ItemRepository;
import org.test.checkout.repository.RulesRepository;

import java.math.BigDecimal;
import java.util.UUID;


@SpringBootApplication
@OpenAPIDefinition(info =
@Info(title = "Checkout API", version = "1.0", description = "Documentation Checkout API API v1.0")
)
public class CheckoutApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckoutApplication.class, args);
	}

	@Bean
	ItemRepository iRepository() {
		ItemRepository repository = new ItemRepository();
		repository.add(new Item("44c67bf9-a247-4bb6-bfb4-8c6f09b71286", "VOUCHER","Gift Card",new BigDecimal(5.0f)));
		repository.add(new Item("e4ce84c7-609d-4a61-844e-e9e3428a85ed", "TSHIRT","Summer T-Shirt",new BigDecimal(20.0f)));
		repository.add(new Item("8aef2a78-dc31-4d27-96b6-e3ba8b9c8813", "PANTS","Summer Pants",new BigDecimal(7.5f)));
		return repository;
	}

	@Bean
	RulesRepository rRepository() {
		RulesRepository repository = new RulesRepository();
		repository.add(new Rules(1, "A 2-for-1 special on VOUCHER items","VOUCHER",TypeEnum.FIFTY,new BigDecimal(2),0));
		repository.add(new Rules(2, "buy 3 or more TSHIRT items","TSHIRT",TypeEnum.QTY,new BigDecimal(19),3));
		return repository;
	}

	@Bean
	CartRepository cRepository() {
		CartRepository repository = new CartRepository();
		return repository;
	}

	@Bean
	public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
		return new OpenAPI()
				.components(new Components())
				.info(new io.swagger.v3.oas.models.info.Info().title("Checkout API").version(appVersion)
						.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}
}
