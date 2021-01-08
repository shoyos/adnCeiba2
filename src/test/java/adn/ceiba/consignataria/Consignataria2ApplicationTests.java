package adn.ceiba.consignataria;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Consignataria2ApplicationTests {
	/*
	@Bean
	@Qualifier(value = "entityManager")
	public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
	    return entityManagerFactory.createEntityManager();
	}*/
	@Test
	void main () {
		Consignataria2Application.main( new String[] {});
	}


}
