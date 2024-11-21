package tests;

import org.junit.jupiter.api.Test;

import utils.Generator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;
import static java.time.Duration.ofMillis;

public class GeneratorTest {
	
	private Generator generator;
	
	@BeforeEach
	void setUp() throws Exception {
		generator = Generator.getInstance();
	}
	
	@AfterEach
	void tearDown() throws Exception {
		generator = null;
	}
	
	@Test
	@DisplayName("Test de instancia")
	void testInstance() {
		assertNotNull(generator);
	}
	
	@Test
	@DisplayName("Test timeout")
	void timeout() {
		assertTimeout(ofMillis(1000), () -> {
			generator.generateId("Activity");
		});
	}
	
	@Test
	@DisplayName("Generar id")
	void generarId() {
		assertNotNull(generator.generateId("Activity"));
	}
	
}
