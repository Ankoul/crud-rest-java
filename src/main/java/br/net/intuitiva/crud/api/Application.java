package br.net.intuitiva.crud.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class Application {

	@Value("${project.version}")
	private String version;

	@Value("${project.artifactId}")
	private String artifactId;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getVersion() {
		return artifactId + " v" + version;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
