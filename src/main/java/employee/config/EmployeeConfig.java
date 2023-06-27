package employee.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"employee"})
public class EmployeeConfig {

	@Bean
	public EntityManager getEntityManager() {

		EntityManager em = Persistence.createEntityManagerFactory("amit").createEntityManager();
		return em;
	}

}
