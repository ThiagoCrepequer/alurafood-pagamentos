package br.com.alurafood.pagamentros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.commons.httpclient.HttpClientConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "br.com.alurafood.pagamentros.http")
@ImportAutoConfiguration({FeignAutoConfiguration.class, HttpClientConfiguration.class})
public class PagamentrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PagamentrosApplication.class, args);
	}

}
