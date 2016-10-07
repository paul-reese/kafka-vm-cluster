package io.pivotal.servicebroker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaServiceBrokerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaServiceBrokerApplication.class, args);
	}
}
