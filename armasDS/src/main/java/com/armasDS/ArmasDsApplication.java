package com.armasDS;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArmasDsApplication {

	public static void main(String[] args) {
		String env = System.getenv("ENV");
		if (env == null || env.equals("local")) {
//			Dotenv dotenv = Dotenv.load();
//			System.setProperty("DATABASE_URL", dotenv.get("DATABASE_URL"));
//			System.setProperty("DATABASE_USERNAME", dotenv.get("DATABASE_USERNAME"));
//			System.setProperty("DATABASE_PASSWORD", dotenv.get("DATABASE_PASSWORD"));
			Dotenv dotenv = Dotenv.load();
			String databaseUrl = dotenv.get("DATABASE_URL");
			String databaseUsername = dotenv.get("DATABASE_USERNAME");
			String databasePassword = dotenv.get("DATABASE_PASSWORD");

			System.setProperty("DATABASE_URL", databaseUrl);
			System.setProperty("DATABASE_USERNAME", databaseUsername);
			System.setProperty("DATABASE_PASSWORD", databasePassword);

			// Log para ver los valores
			System.out.println("DATABASE_URL: " + databaseUrl);
			System.out.println("DATABASE_USERNAME: " + databaseUsername);
		}

		SpringApplication.run(ArmasDsApplication.class, args);
	}

}
