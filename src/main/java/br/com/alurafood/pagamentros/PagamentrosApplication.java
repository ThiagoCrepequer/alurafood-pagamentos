package br.com.alurafood.pagamentros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PagamentrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PagamentrosApplication.class, args);
	}

}
