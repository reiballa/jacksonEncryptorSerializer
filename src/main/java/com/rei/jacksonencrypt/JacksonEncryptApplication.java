package com.rei.jacksonencrypt;

import com.google.common.hash.Hashing;
import com.google.gson.*;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class JacksonEncryptApplication {

	public static void main(String[] args) {
		SpringApplication.run(JacksonEncryptApplication.class, args);
	}

}
